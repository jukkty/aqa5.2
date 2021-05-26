import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class Tests {
    private final UserGenerator userGenerator = new UserGenerator();

    @BeforeEach
    void setUp() {
        open("http://localhost:7777");
    }

    @Test
    @DisplayName("Валидные данные активного пользователя")
    void shouldTestValidActive() {
        UserData data = userGenerator.generateActiveUser();
        $("[name='login']").setValue(data.getLogin());
        $("[name='password'").setValue(data.getPassword());
        $("[data-test-id='action-login']").click();
        $(withText("Личный кабинет")).waitUntil(Condition.visible, 3000);
    }

    @Test
    @DisplayName("Валидные данные блокированного пользователя")
    void shouldTestValidBlocked() {
        UserData data = userGenerator.generateBlockedUser();
        $("[name='login']").setValue(data.getLogin());
        $("[name='password'").setValue(data.getPassword());
        $("[data-test-id='action-login']").click();
        $(withText("Пользователь заблокирован")).waitUntil(Condition.visible, 3000);
    }
    @Test
    @DisplayName("Невалидный логин активного пользователя")
    void shouldTestActiveInvalidLogin() {
        UserData data = userGenerator.generateActiveUserInvalidLogin();
        $("[name='login']").setValue(data.getLogin());
        $("[name='password'").setValue(data.getPassword());
        $("[data-test-id='action-login']").click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 3000);
    }
    @Test
    @DisplayName("Невалидный пароль активного пользователя")
    void shouldTestActiveInvalidPassword() {
        UserData data = userGenerator.generateActiveUserInvalidPassword();
        $("[name='login']").setValue(data.getLogin());
        $("[name='password'").setValue(data.getPassword());
        $("[data-test-id='action-login']").click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 3000);
    }
    @Test
    @DisplayName("Невалидный логин блокированного пользователя")
    void shouldTestBlockedInvalidLogin() {
        UserData data = userGenerator.generateBlockedUserInvalidLogin();
        $("[name='login']").setValue(data.getLogin());
        $("[name='password'").setValue(data.getPassword());
        $("[data-test-id='action-login']").click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 3000);
    }
    @Test
    @DisplayName("Невалидный пароль блокированного пользователя")
    void shouldTestBlockedInvalidPassword() {
        UserData data = userGenerator.generateBlockedUserInvalidPassword();
        $("[name='login']").setValue(data.getLogin());
        $("[name='password'").setValue(data.getPassword());
        $("[data-test-id='action-login']").click();
        $(withText("Неверно указан логин или паро1ль")).waitUntil(Condition.visible, 3000);
    }
}
