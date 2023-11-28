package org.example;

import org.example.craw.CrawlingModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;


public class Main {
    public static void main(String[] args) {
        // 1. WebDriver와 ChromeDriver 설정
        // 프로젝트 폴더 기준으로 chromedirver.exe 파일의 위치를 작성
//        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new SafariDriver();


        // 2. 웹 페이지 접속
        String baseUrl = "https://movie.daum.net/ranking/boxoffice/weekly";
        // String searchTerm = "Java";
        // String url = baseUrl + "/wiki/" + searchTerm;

        driver.get(baseUrl);


        // 3. 데이터 추출
        ArrayList<CrawlingModel> car_data = new ArrayList<>();

        WebElement car_container = driver.findElement(By.cssSelector(".list_movieranking"));

        List<WebElement> car_links = car_container.findElements(By.cssSelector(".tit_item>a"));

        for(int i= 0; i < car_links.size(); i++) {
            String link = car_links.get(i).getAttribute("href");
            // links.add(link);
            driver.get(link);

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            String manufacturer = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[1]/h3/span[1]")).getText();
            String modelGroup = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div[1]/dl[1]/dd")).getText();
            String model = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div[1]/dl[5]/dd")).getText();


            CrawlingModel crawlingModel = new CrawlingModel(manufacturer, modelGroup, model);

            System.out.println((i+1)+". "+ manufacturer + " (" + modelGroup + ")");

            car_data.add(crawlingModel);

            driver.navigate().back();
            // System.out.println(link);
        }

        // 4. WebDriver 종료
        driver.quit();
    }

}
