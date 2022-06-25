package Steps;

import PageObjects.ContactPage;
import PageObjects.MakersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.hooks;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class dejanos_un_mensaje_form_steps {
    private static final WebDriver driver = hooks.getDriver();
    String getCellPhone;

    @Given("la siguiente url {string}")
    public void la_siguiente_url(String string) {
        MakersPage confirmPage = new MakersPage(driver);
        String getUrl = confirmPage.confirmPage();
        assertEquals( getUrl,string);
    }
    @When("hacemos clic en el enlace de CONTACTO")
    public void hacemos_clic_en_el_enlace_de_CONTACTO() {
        MakersPage confirmPage = new MakersPage(driver);
        confirmPage.clickContact();
    }
    @Then("capturar el numero de celular de servicio al cliente")
    public void capturar_el_numero_de_celular_de_servicio_al_cliente() {
        ContactPage contactPage = new ContactPage(driver);
        getCellPhone = contactPage.getCellPhoneCustomerService();
        System.out.println(getCellPhone);
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("llenar el formulario dejanos un mensaje y en el campo mensaje adjuntar el numero de celular capturado")
    public void llenar_el_formulario_y_en_el_campo_mensaje_adjuntar_el_numero_de_celular_capturado() throws IOException {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.setName("name");
        contactPage.setLastName("Lastname");
        contactPage.setEmail("noemail@gmail.com");
        contactPage.setPhone("12222");
        contactPage.setMessage(getCellPhone);
        contactPage.takeScreenshoots();
    }
    @Then("antes de hacer clic en el boton enviar mensaje tomar un pantallazo con la informacion diligenciada")
    public void de_hacer_clic_en_el_boton_tomar_un_pantallazo_con_la_informacion_diligenciada() {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.clickSubmitButton();
    }
}
