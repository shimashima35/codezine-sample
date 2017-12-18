package com.example.selenide;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.example.selenide.page.CheckInfoPage;
import com.example.selenide.page.FinalConfirmPage;
import com.example.selenide.page.InputPage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.monte.media.Format;
import org.monte.media.math.Rational;

import java.awt.*;
import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

/**
 * Unit test for simple App.
 */
public class SampleTest {

    public void startRecording(String name) throws Exception {
        File file = new File("record");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0,0, width, height);

        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        this.screenRecorder = new ScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey,  MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                        FrameRateKey, Rational.valueOf(30)),
                null, file, name);
        this.screenRecorder.start();
    }

    public void stopRecording() throws Exception {
        this.screenRecorder.stop();
    }

    private ScreenRecorder screenRecorder;

    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestWatcher watchman = new TestWatcher() {

        @Override
        protected void succeeded(Description d) {
            System.out.println("I am succeeded() method. name -> " + d.getMethodName());
            screenRecorder.getCreatedMovieFiles().stream().filter(a -> a.toPath().toString().contains(testName.getMethodName())).forEach(a -> a.deleteOnExit());
        }

        @Override
        protected void failed(Throwable th, Description d) {
            System.out.println("I am failed() method. name -> " + d.getMethodName());
            System.out.println(th.toString());
        }
    };


    @Before
    public void before() throws Exception {
        Configuration.browser = WebDriverRunner.GECKO;
        startRecording(testName.getMethodName());
        
    }

    public void after() throws Exception {
        stopRecording();
    }

    @Test
    public void 正常系確認() {
        InputPage inputPage = open("http://example.selenium.jp/reserveApp/", InputPage.class);
        inputPage.setReserveYear("2017");
        inputPage.setReserveMonth("10");
        inputPage.setReserveDay("1");
        inputPage.setReserveTerm("2");
        inputPage.setBreakfastOn();
        inputPage.setGuestName("東京太郎");
        inputPage.setPlanA(false);
        inputPage.setPlanA(false);
        CheckInfoPage checkPage = inputPage.clickGotoNext();
        assertThat(checkPage.getErrorCheckResult(), is(""));
        assertThat(checkPage.getDateFrom(), is("2017年10月1日"));
        assertThat(checkPage.getDateTo(), is("2017年10月3日"));
        assertThat(checkPage.getDaysCount(), is("2"));
        assertThat(checkPage.getHeadcount(), is("1"));
        assertThat(checkPage.getBfOrder(), is("あり"));
        assertThat(checkPage.getGuestName(), is("東京太郎"));
        assertThat(checkPage.getPrice(), is("17750"));
        FinalConfirmPage finalPage = checkPage.doCommit();
        assertThat(finalPage.getErrorCheckResult(), is(""));
    }

    @Test
    public void 三ヶ月以上先の予約はできない() {
        InputPage inputPage = open("http://example.selenium.jp/reserveApp/", InputPage.class);
        inputPage.setReserveYear("2020");
        inputPage.setReserveMonth("12");
        inputPage.setReserveDay("24");
        inputPage.setReserveTerm("2");
        inputPage.setBreakfastOn();
        inputPage.setGuestName("東京 太郎");
        inputPage.setPlanA(true);
        inputPage.setPlanA(true);
        CheckInfoPage checkPage = inputPage.clickGotoNext();
        assertEquals("宿泊日には、3ヶ月以内のお日にちのみ指定できます。", checkPage.getErrorCheckResult());
    }


}
