public class Pokedex{
	private Pokemon [] pokemones;
	private String [] nombreAtaques = new String[SetupPokemon.cantidadAtaques];

	Pokedex(){
		pokemones = new Pokemon[SetupPokemon.cantidadPokemones];
		
		for(int i=0;i<SetupPokemon.cantidadPokemones;i++){
			nombreAtaques = SetupPokemon.ataques[i];
			pokemones[i] = new Pokemon(SetupPokemon.level[i],i,SetupPokemon.nombres[i],SetupPokemon.tipo[i],SetupPokemon.ps_max[i],SetupPokemon.poder[i],SetupPokemon.defensa[i],SetupPokemon.velocidad[i],nombreAtaques);
		}
	}

	public Pokemon getPokemon(int numeroPokemon){
		return pokemones[numeroPokemon];
	}

	public void capturarPokemon(int pos){
		this.pokemones[pos].setCapturado();
	}

	public int getCantidadPokemones(){
		return SetupPokemon.cantidadPokemones;
	}

	public void listarPokedex(){
		System.out.println("Pokedex Personal");
		System.out.println("======= ========\n");
		
		for(int i=0;i<SetupPokemon.cantidadPokemones;i++){
			if(pokemones[i].getCapturado()){
				System.out.println("Id: "+pokemones[i].getId()+"\n- Nivel: "+pokemones[i].getLevel()+"\n- Exp actual:  "+pokemones[i].getAcumulador()+"/100"+ "\n- Nombre: "+pokemones[i].getNombre()+"\n- Tipo: "+pokemones[i].getTipo()+"\n- Vida: "+pokemones[i].getPs_max()+"\n- Poder pp: "+pokemones[i].getPoder()+"\n- Defensa pp: "+pokemones[i].getDefensa()+"\n- Velocidad pp: "+pokemones[i].getVelocidad());
				
				for(int j=0;j<3;j++){
					System.out.println("\nAtaque: "+pokemones[i].getAtaques()[j].getNombre());
					System.out.println("*** Dano:"+pokemones[i].getAtaques()[j].getDano());
					System.out.println("*** Cura:"+pokemones[i].getAtaques()[j].getCura());
					System.out.println("*** Bloqueo:"+pokemones[i].getAtaques()[j].getBloqueo());
				}
				System.out.println("**********************");
			}	
		}
		System.out.println("\n\nPresione ENTER para continuar");
	}
}