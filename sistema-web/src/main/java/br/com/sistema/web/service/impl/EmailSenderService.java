package br.com.sistema.web.service.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;

import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.service.IEmailSenderService;
import br.com.sistema.web.util.SUtils;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

/**
 *
 * @author edmilson.reis
 *
 */
@Service
public class EmailSenderService implements IEmailSenderService {

	private static final Logger logger = LogManager.getLogger(EmailSenderService.class);

	private static final String EMAIL_ALTERA_SENHA_TEMPLATE_NAME = "email-altera-senha-body.ftl";
	private static final String ENCODING = "UTF-8";

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Configuration freemarker;

	@Override
	public Boolean sendTestEmail(String email, Map<String, Object> data) {
		logger.info("Iniciou Método sendTestEmail...");

		try {
			this.sendEmail(email, EMAIL_ALTERA_SENHA_TEMPLATE_NAME, data);
		} catch (MessagingException e) {
			return false;
		}
		return true;
	}

	private String mergeTemplate(String templateName, Map<String, Object> data) {

		String fileExtensao = templateName.substring(templateName.lastIndexOf("."), templateName.length());

		if (StringUtils.isEmpty(templateName.trim())) {
			throw new BusinessException("O modelo fornecido é nulo, vazio ou em branco.");
		}

		if (!fileExtensao.trim().equals(expectedTemplateExtension())) {
			throw new BusinessException("Esperou um arquivo de modelo Freemarker com extensão 'ftl', enquanto '"
					+ fileExtensao + "' foi dado.");
		}

		try {
			return FreeMarkerTemplateUtils.processTemplateIntoString(
					freemarker.getTemplate(templateName, Charset.forName("UTF-8").name()), data);
		} catch (IOException | TemplateException e) {
			logger.error("Erro ao fazer merge do template.", e);
			throw new BusinessException("Erro ao montar template.");
		}
	}

	private String expectedTemplateExtension() {
		return ".ftl";
	}

	private void sendEmail(String email, String template, Map<String, Object> myData)
			throws MessagingException, BusinessException {
		this.sendEmail(email, template, myData, null);
	}

	private void sendEmail(String email, String template, Map<String, Object> myData, String[] copia)
			throws MessagingException, BusinessException {

		String message = this.mergeTemplate(template, myData);

		MimeMessage mimeMessage = this.mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, ENCODING);
		helper.setTo(email);
		if (copia != null) {
			helper.setCc(copia);
		}
		helper.setFrom(SUtils.EMAIL_NOREPLY_SENDER);
		helper.setText(message, true);
		helper.setSubject("[MW E-mail] " + myData.get("subject"));

		this.mailSender.send(mimeMessage);
	}

}
