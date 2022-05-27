package br.com.digitalhouse.thebookclub.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI springBlogPessoalOpenAPI() {
		return new OpenAPI()
				.info(new Info()
					.title("Aplicação do The Book Club")
					.description("The Book Club é um ecommerce destinado á venda de livros")
					.version("v.0.1")
					.license(new License()
						.name("Digital House")
						.url("https://digitalhouse.com"))
					.contact(new Contact()
							.name("Treinamento Porto Seguro")
							.email("portoseguro@porto.com")))
				.externalDocs(new ExternalDocumentation()
						.description("Github - Repositório do projeto")
						.url("https://github.com/DigitalHouse-PortoSeguro/projetoIntegradorEcommerce"));
	}
	
	@Bean
	public OpenApiCustomiser customerGlobalHeaderOpenApiCustomizer() {
		return openApi -> {
			openApi.getPaths().values().forEach(path -> {
				path.readOperations().forEach(operation -> {
					ApiResponses apiResponses = operation.getResponses();
					
					apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
					apiResponses.addApiResponse("201", createApiResponse("Objeto criado"));
					apiResponses.addApiResponse("204", createApiResponse("Objeto removido"));
					apiResponses.addApiResponse("400", createApiResponse("Erro na requisição"));
					apiResponses.addApiResponse("401", createApiResponse("Acesso não autorizado"));
					apiResponses.addApiResponse("404", createApiResponse("Objeto não encontrado"));
					apiResponses.addApiResponse("500", createApiResponse("Erro na aplicação"));
				});
			});
		};
	}

	private ApiResponse createApiResponse(String description) {
		return new ApiResponse().description(description);
	}
}








