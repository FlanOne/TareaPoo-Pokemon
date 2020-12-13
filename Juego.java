import java.io.*;

public class Juego{
	private Pokedex pokedexGral;
	private Partida [] partidas;
	private int contadorPartidas;
    private Mapa mapagenerico;
	private BufferedReader buffer;

	Juego(){
        //this.Mapagenerico= new Mapa(this.pokedexGral);
		this.pokedexGral = new Pokedex();
		this.partidas = new Partida[SetupPokemon.cantidadPartidas]; 
		this.contadorPartidas = 0;
        this.mapagenerico= new Mapa(pokedexGral);
	}

	public void jugar(){
		this.partidas[this.contadorPartidas]= new Partida(pokedexGral,mapagenerico);
	}
}