import java.io.*;

public class Personaje{
	private int id;
	private String nombre;
	private String usuario;
	private Pokedex pokedexPersonal;
    private String genero;

	Personaje(int id, String nombre, String usuario,String genero, Pokedex pokedexGral){
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
        this.genero=genero;
		this.pokedexPersonal = new Pokedex();
	}

	public void escogerPokemon(Pokedex pokedexGral){
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("***************************************************************************");
		System.out.println("||                                                                       ||");
		System.out.println("||Eh! Alto! No te vayas aun!..                                           ||");
		System.out.println("||Cuidado! En la hierba viven POKEMON salvajes! Necesitas a tu propio    ||");
		System.out.println("||POKEMON como proteccion!                                               ||");
		System.out.println("||Elije a tu pokemon inicial para iniciar la aventura....                ||");
		System.out.println("||                                                                       ||");
		System.out.println("***************************************************************************");
		int n=SetupPokemon.cantidadPokemones;
		System.out.println(n);

		int op=-1;
		boolean flag=false;

		do{
			System.out.println("||                                                                       ||");
			if(flag) System.out.println("||Ingrese una opcion valida...                                           ||");
			System.out.println("||Elije tu pokemon inicial....                                           ||");
			System.out.println("||                                                                       ||");
			
			try{
                while((op<0)||op>=4){
                    System.out.println("||1.- "+pokedexGral.getPokemon(0).getNombre());
                    System.out.println("||2.- "+pokedexGral.getPokemon(3).getNombre());
                    System.out.println("||3.- "+pokedexGral.getPokemon(6).getNombre());
                    op = Integer.parseInt(buffer.readLine());
                                    
                    if (op==1){
                        op=op-1;                           
                    }
                    else if (op==2){
                        op=3;
                    }
                    else if(op==3){
                        op=op*2;
                        break;
                    }
                    else {
                    	System.out.println("||                                                                       ||");
                        System.out.println("||Ingrese una opcion valida                                              ||");
                        System.out.println("||                                                                       ||");
                    }                
                }
				flag=true;

			}catch(IOException e){
				System.out.println("||                                                                       ||");
				System.out.println("||Error de lectura desde el teclado...                                   ||");
				System.out.println("||                                                                       ||");
			}	
		}while((op<0)||(op>n));

		pokedexPersonal.capturarPokemon(op);
		System.out.println("***************************************************************************");
		System.out.println("||                                                                       ||");
		System.out.println("||Su pokemon inicial es "+ pokedexPersonal.getPokemon(op).getNombre()+", felicitaciones!!!");
		System.out.println("||                                                                       ||");
		System.out.println("***************************************************************************");
	}
    
    public void pokemonSanhueza(){
        pokedexPersonal.capturarPokemon(151);
    }
	public void listarPokedexPersonal(){
		this.pokedexPersonal.listarPokedex();
	}
	public Pokedex getPokedex(){
		return pokedexPersonal;
	}
}