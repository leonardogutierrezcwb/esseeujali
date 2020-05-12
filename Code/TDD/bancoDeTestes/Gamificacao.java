package bancoDeTestes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import src.sistema.SistemaDePontuacao;

class Gamificacao {
	
	//US5.2 - Requisito 1:
	@Test
	void selecionandoDados() throws FileNotFoundException, IOException {
		SistemaDePontuacao P = new SistemaDePontuacao();
		List<String[]> dados = P.coletandoDadosDoUsuario("Mateus Brugnaroto");
		assertEquals(dados.get(0)[0], "O Poder da Autorresponsabilidade");
		assertEquals(dados.get(1)[0], "Vamos ve o que vai da pra fechar");
		assertEquals(dados.get(2)[0], "Esse aqui e a pegadinha do jogo");
	}
	@Test
	void selecionandoDadoDeUmUsuarioInexistente() throws FileNotFoundException, IOException {
		SistemaDePontuacao P = new SistemaDePontuacao();
		List<String[]> dados = P.coletandoDadosDoUsuario("Mateus");
		assertEquals(dados.isEmpty(), true);
	}
	
	//US5.2 - Requisito 2:
	@Test
	void calculandoPontosTotal() throws FileNotFoundException, IOException {
		SistemaDePontuacao P = new SistemaDePontuacao();
		assertEquals(P.calculandoPontuacao("Mateus Brugnaroto"), 22);
	}
	
	//US5.3 - Requisito 1:
	@Test
	void listaOsEstilosPreferidos() throws FileNotFoundException, IOException {
		SistemaDePontuacao P = new SistemaDePontuacao();
		List<String> estilos = P.identificandoEstilosDoLeitor("Nanotec");
		assertEquals(estilos.get(0), "Neg�cios");
		assertEquals(estilos.get(1), "Autoajuda");
	}
	
	//US6.1 - Requisito 1:
		@Test
		void listandoONomeDosLeitoresQuePontuaram() throws FileNotFoundException, IOException {
			SistemaDePontuacao P = new SistemaDePontuacao();
			assertEquals(P.rankingDosPontuadores().get(0), "Posicao: 1 -> Nome: Nanotec | Pontuacao: 26");
			assertEquals(P.rankingDosPontuadores().get(1), "Posicao: 2 -> Nome: Mateus Brugnaroto | Pontuacao: 22");
		}	
}
