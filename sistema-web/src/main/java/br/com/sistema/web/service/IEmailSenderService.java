/**
 *
 */
package br.com.sistema.web.service;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
*
* @author anderson.aristides
*
*/
@Service
public interface IEmailSenderService {

	Boolean sendTestEmail(String email, Map<String, Object> data);

}
