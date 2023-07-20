package guru.qa;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpathExamples() {
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        // используем специальный тестовый id
        $("[data-testid=email]").setValue("1");
        $("input[data-testid=email]").setValue("1"); // вариант с указанием типа элемента
        $(by("data-testid", "email")).setValue("1");// вариант с указанием имени атрибута и его значения

        // как это будет выглядеть в XPath
        $x("//*[@data-testid='email']"); //без указания типа элемента
        $x("//input[@data-testid='email']"); // с указанием типа элемента

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        // используем id
        $("[id=email]").setValue("1");
        $("#email").setValue("1"); // сокращённый вариант записи
        $("input#email").setValue("1"); // сокращённый вариант, с указанием типа элемента

        // <input type="email" class="inputtext login_form_input_box" name="email">
        // что делать в случае, когда нет id, в данном случае используем name
        $("[name=email]").setValue("1");
        $(byName("email")).setValue("1"); //альтернативный вариант, с использованием поиска byName(работает только с name), более лаконично

        // <input type="email" class="inputtext login_form_input_box">
        // а если у нас нет даже name? к типу элемента обращаться не стоит, это плохая практика, обращаемся по классу
        $("[class=inputtext][class=login_form_input_box]").setValue("1");
        $(".inputtext.login_form_input_box").setValue("1"); //такое сокращение возможно только для class
        $(".login_form_input_box").setValue("1"); // inputtext выглядит лишним, он не обязателен, его тоже можно сократить

        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("1"); // вариант для Xpath

        // Вариант, когда у нас 2 элемента:
        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box">
        // </div>
        $(".inputtext .login_form_input_box").setValue("1"); // пробел после .inputtext означает что дальше идёт поиск нового элемента
        $("div.inputtext input.login_form_input_box").setValue("1"); // можем указать и типы элементов
        $("div.inputtext").$("input.login_form_input_box").setValue("1"); // можем сделать как будто бы 2 вызова
        // первый вариант - самый лаконичный

        // Поиск по тексту.
        // <div>Hello, qa.guru!</div>

        // вариант для XPath
        $x("//div[text()='Hello, qa.guru!']").click();
        
        $(byText("Hello, qa.guru!")).click(); // В Селениде есть возможность поиска по тексту
        $(withText("o, qa.g")).click(); // поиск по подстроке
    }
}
