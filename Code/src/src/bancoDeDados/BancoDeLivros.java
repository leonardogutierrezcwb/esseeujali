package src.bancoDeDados;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BancoDeLivros extends TratamentoDeArquivos {
	private List<String[]> _isDadosDoArquivo;
	
	public BancoDeLivros () throws FileNotFoundException, IOException {
		_isDadosDoArquivo = lendoOArquivo("Registro de Livros");
	}

	public String[] getLivro(String nomeLivro) {
		int i = 0;
		
		while (i < _isDadosDoArquivo.size()) {
			if (_isDadosDoArquivo.get(i)[0].equalsIgnoreCase(nomeLivro)) return _isDadosDoArquivo.get(i);
			i++;
		}
		return null;
	}

	public List<String> getListaDeLivros() {
		List<String> listaLivros = new ArrayList<>();
		
		if (_isDadosDoArquivo == null) {
			listaLivros.add("N�o h� livros na biblioteca");
			return listaLivros;
		}
		
		for (int i = 0; i < _isDadosDoArquivo.size(); i++) { listaLivros.add(_isDadosDoArquivo.get(i)[0]); }
		
		return listaLivros;
	}
	
	
	
}
