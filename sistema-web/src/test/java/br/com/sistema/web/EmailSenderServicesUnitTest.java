/**
 *
 */
package br.com.sistema.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.service.IEmailSenderService;

/**
 *
 * @author edmilson.reis
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailSenderServicesUnitTest {

	@Autowired
	private IEmailSenderService emailSenderService;

	@Test
	public void sentRegisterEmailTest() throws BusinessException {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("subject", "Reset Senha - DISK-WEB");
		data.put("nome", "Edmilson Alves dos reis");
		data.put("novaSenha", "abt123");
//		Boolean sendEmail = this.emailSenderService.sendTestEmail(SUtils.EMAIL_TEST_SENDER, data);
//		assertTrue(sendEmail);
	}

}
