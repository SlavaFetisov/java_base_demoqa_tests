package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testData.TestData.*;

public class PracticeFormTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(genderWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth + ":not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subjectArts).pressEnter();
        $("#subjectsInput").setValue(subjectMath).pressEnter();
        $("#subjectsInput").setValue(subjectMaths).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbieMusic)).click();
        $("#hobbiesWrapper").$(byText(hobbieSports)).click();
        $("#hobbiesWrapper").$(byText(hobbieReading)).click();
        $("#uploadPicture").uploadFromClasspath(nameOfFile);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(country).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(Condition.exactText(messageAfterSubmitting));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(genderWrapper));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(dateOfBirth));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjectArts + ", " + subjectMath + ", " + subjectMaths));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbieMusic + ", " + hobbieSports + ", " + hobbieReading));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(nameOfFile));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(country + " " + city));
    }
}