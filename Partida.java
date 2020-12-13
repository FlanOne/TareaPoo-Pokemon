import java.io.*;
public class Partida{
	private BufferedReader buffer;
	private Personaje jugador;
    private Personaje sanhueza;
	private Combate [] combates;
	private int combateActual;
	private Pokedex pokedexGral;
    private Mapa mapagenerico;
    private Mochila miMochila;

	Partida(Pokedex pokedexGral, Mapa mapagenerico){
		buffer = new BufferedReader(new InputStreamReader(System.in));      
		combates = new Combate[SetupPokemon.cantidadCombates];
		combateActual = 0;
        this.mapagenerico= mapagenerico;
		this.pokedexGral = pokedexGral;
        this.sanhueza=new Personaje(0,"alejandro sanhueza","profesor","Chico",pokedexGral);
        sanhueza.pokemonSanhueza();
		crearUsuario(pokedexGral);
		menu();
	}
        
	private void crearUsuario(Pokedex pokedexGral){
		String nombre;
		String usuario;     
		String genero;
		int opGen = 0;

		try{
            System.out.println("\n***************************************************************************");
			System.out.println("||	                                .::.                             ||");
			System.out.println("||	                              .;:**'                           	 ||");
			System.out.println("||	                              `                                  ||");
			System.out.println("||	  .:XHHHHk.              db.   .;;.     dH  MX                   ||");
			System.out.println("||	oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN        ||");
			System.out.println("||	QMMMMMb  'MMX       MMMMMMP !MX' :M~   MMM MMM  .oo. XMMM 'MMM   ||");
			System.out.println("||	  `MMMM.  )M> :X!Hk. MMMM   XMM.o'  .  MMMMMMM X?XMMM MMM>!MMP   ||");
			System.out.println("||	   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM `' MX MMXXMM    ||");
			System.out.println("||	    ~MMMMM~ XMM. .XM XM`'MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP    ||");
			System.out.println("||	     ?MMM>  YMMMMMM! MM   `?MMRb.    `'''   !L'MMMMM XM IMMM     ||");
			System.out.println("||	      MMMX   'MMMM'  MM       ~%:           !Mh.''' dMI IMMP     ||");
			System.out.println("||	      'MMM.                                             IMX      ||");
			System.out.println("|| 	       ~M!M                                             IMP      ||");
			System.out.println("||                                MMMMMMWMMMMMM                          ||");
			System.out.println("||                          MMWNKOkxdoollooddkOKNWMM                     ||");
			System.out.println("||		         MMMNKKKx:'.............';lx0NWM                 ||");
			System.out.println("||		       MMWKd::OWXl..................':d0WM               ||");
			System.out.println("||		     MMW0o,..,OWNl.....................,l0WM             ||");
			System.out.println("||		    MMMKc....,OWNo.......................,oKWM           ||");
			System.out.println("||		   MMMMK:....,OWNl.........................:OWM          ||");
			System.out.println("||		  MWXXMNo'...cKMXc..........................;OWM         ||");
			System.out.println("||		 MMKllKWNOxxkXWXd'...,dOOOOOOOOkl'...........:0MM        ||");
			System.out.println("||		 MNd'.;ok0KK0Od:'....:0WXOkdddddc.............oNM        ||");
			System.out.println("||		 MK:.....''''........:0W0dl::::;..............;0M        ||");
			System.out.println("||		 WO;....,:ccc;'......:0MWNXKKKKx,.............,kW        ||");
			System.out.println("||		 Wk,.,oOXNXXNX0x:....:0W0dc;;;;,..............'xW        ||");
			System.out.println("||		 M0;:ONXxl::cokk:....:0MXOkxxxxxc'............,OM        ||");
			System.out.println("||		 MXdOWKc.............,okkkkkkkkkoc::'.....,::,cKM        ||");
			System.out.println("||		  WXNWO;........................;ONNO:....oXNkOW         ||");
			System.out.println("||		   MMMXd,....';;'...............;0MMWXd,..dNWNW          ||");
			System.out.println("||		    MWWNKxdodOXKl'..............;0MNXNNOc'dWMM           ||");
			System.out.println("||		     MKkk0KKKOxc,...............:0WKll0WXxkWM            ||");
			System.out.println("||		      WKo;,,'...................;0WKc.;xNWWM             ||");
			System.out.println("||		        W0o;....................;0WKc.,dXM               ||");
			System.out.println("||		         WXkl;'................;xXKkxKWM                 ||");
			System.out.println("||		           MWX0xoc:;,'''''',,:cokKNM                     ||");
			System.out.println("||			        MMWNXKK0000KKXNWMM                       ||");
			System.out.println("||	                                                                 ||");
			System.out.println("||	       POKEMON FUNDAMENTOS DE LENGUAJES DE PROGRAMACION          ||");
			System.out.println("***************************************************************************");
			System.out.println("||                                                                       ||");
			System.out.println("||Bienvenidos al mundo de POKEMON!,  Me llamo CLAUDIO!                   ||");
			System.out.println("||Pero la gente me llama el PROFESOR POKEMON!, Este mundo esta habitado  ||");
			System.out.println("||por unas criaturas programadas llamadas POKEMON!. Para algunos, los    ||");
			System.out.println("||POKEMON son mascotas. Pero otros los usan para pelear.                 ||");
			System.out.println("||En cuanto a mi... Estudio y programo a los POKEMON como profesion.     ||");
			System.out.println("||                                                                       ||");
			System.out.println("***************************************************************************");
			System.out.println("||                                                                       ||");
			System.out.println("||Pero antes de que continuemos, primero dime como te llamas...          ||");
			System.out.println("||Ingrese su nombre:                                                     ||");
			nombre = buffer.readLine();
			System.out.println("||Ingrese un nombre de usuario:                                          ||");
			usuario = buffer.readLine();
			System.out.println("||                                                                       ||");
			System.out.println("***************************************************************************");
			System.out.println("||                                                                       ||");
            System.out.println("||Que eres, chico o chica:                                               ||");
			System.out.println("||[1] Chico.                                                             ||");
			System.out.println("||[2] Chica.                                                             ||");
			opGen = Integer.parseInt(buffer.readLine());
			System.out.println("||                                                                       ||");
			System.out.println("***************************************************************************");
			System.out.println("||Perfecto ahora puedes ir a comenzar tu aventura...                     ||");
			System.out.println("||Comienza el juego...                                                   ||");
            if(opGen == 1){
				genero = "Chico";
				this.jugador = new Personaje(1,nombre,usuario,genero,pokedexGral);	
			}
			else if(opGen == 2){
				genero = "Chica";
				this.jugador = new Personaje(1,nombre,usuario,genero,pokedexGral);	
			}

			jugador.escogerPokemon(pokedexGral);
            this.miMochila=new Mochila(jugador,1,1,1,1,true,true,true,true);

		}catch(IOException e){
			System.out.println("Error de lectura desde el teclado...");
		}
	}

	public void menu(){
		int op=0;
        int po=0;
		System.out.println("***************************************************************************");
		System.out.println("||                                                                       ||");
		System.out.println("||Perfecto ahora que ya nos presentamos y esta todo listo para que comi- ||");
		System.out.println("||enzes tu viaje, prosigamos con la aventura!                            ||");
		System.out.println("||                                                                       ||");
		System.out.println("||Tu propia leyenda POKEMON esta a punto de comenzar! Te espera un       ||");
		System.out.println("||mundo de suenos y aventuras con los POKEMON!, Adelante!...             ||");
		System.out.println("||                                                                       ||");	
		System.out.println("***************************************************************************");
		System.out.println("||Comienza el juego...                                                   ||");

		try{
			do{
				System.out.println("***************************************************************************");
				System.out.println("||                                  MENU                                 ||");
				System.out.println("***************************************************************************");
				System.out.println("||Selecciona la accion que quieres realizar:                             ||");
				System.out.println("||         | [1] MAPA    |                   | [2] MOCHILA |             ||");
				System.out.println("||         | [3] POKEDEX |                   | [4] CERRAR  |             ||");
				System.out.println("***************************************************************************");
				op = Integer.parseInt(buffer.readLine());

				switch(op){
					case 1: mapagenerico.menuMapa();
	                        
	                        do{
	                            System.out.println("***************************************************************************");
	                            System.out.println("Selecciona la accion que quieres realizar:                               ||");
	                            System.out.println("||         | [1] COMBATE         |           | [2] POKEDEX |             ||");
	                            System.out.println("||         | [3] VOLVER A MENU   |                                       ||");
	                            System.out.println("***************************************************************************");
	                            po = Integer.parseInt(buffer.readLine());	                            
	                                                    
	                            switch(po){
	                                        case 1: System.out.println("***************************************************************************");
	                                                if(mapagenerico.getMaradona()==true){
	                                                    CombateFinal();          
	                                                }
	                                                else{
	                                                    crearCombate();
	                                                }
	                                                System.out.println("***************************************************************************");
	                                                break;

	                                        case 2: System.out.println("***************************************************************************");
	                                                mostrarPokedex();
	                                                buffer.readLine();
	                                                System.out.println("***************************************************************************");
	                                                break;

	                                        case 3: System.out.println("***************************************************************************");
	                                        		System.out.println("||                                                                       ||");
	                                                System.out.println("||Has vuelto a menu..                                                    ||");
	                                                System.out.println("||                                                                       ||");
	                                                System.out.println("***************************************************************************");
	                                                break;
	                            }         
	                        }while(po!=3);
							break;

					case 2: System.out.println("***************************************************************************");
							miMochila.menu();
							buffer.readLine();
							System.out.println("***************************************************************************");
							break;

					case 3: System.out.println("***************************************************************************");
							mostrarPokedex();
							buffer.readLine();
							System.out.println("***************************************************************************");
							break;
	                
	                case 4: System.out.println("***************************************************************************");
	                		System.out.println("||                                                                       ||");
							System.out.println("||El juego ha terminado,  gracias por jugar PokemonFLP!!!                ||");
							System.out.println("||                                                                       ||");
							System.out.println("***************************************************************************");
							break; 
				}
			}while(op!=4);

		}catch(IOException e){
			System.out.println("||                                                                       ||");
			System.out.println("||Error de lectura desde el teclado...                                   ||");
			System.out.println("||                                                                       ||");
		}
	}
        
	public void crearCombate(){
		int n=SetupPokemon.cantidadPokemones;
		Pokemon aux;
		System.out.println("***************************************************************************");
		System.out.println("||                                                                       ||");
		System.out.println("||Pokedex Personal                                                       ||");
		System.out.println("||======= ========                                                       ||\n");

		for(int i=0;i<n;i++){
			aux = jugador.getPokedex().getPokemon(i);

			if(aux.getCapturado())
				System.out.println((i+1)+".- "+aux.getNombre());
		}
		
		int op=-1;
        int indexRiva=(int)Math.round(Math.random()*151);
        String respuesta="no";
        Pokemon player2= pokedexGral.getPokemon(indexRiva);       
		boolean flag=false;

		do{
			System.out.println("||                                                                       ||");
			if(flag) System.out.println("||Ingrese una opción válida...                                           ||");
			System.out.println("||Elije tu pokemon para la batalla....                                   ||");
			System.out.println("||                                                                       ||");
			
			try{
				op = Integer.parseInt(buffer.readLine());
				flag=true;
			}catch(IOException e){
				System.out.println("||                                                                       ||");
				System.out.println("||Error de lectura desde el teclado...                                   ||");
				System.out.println("||                                                                       ||");
			}

		}while((op<0)||(op>n));

		System.out.println("***************************************************************************");
		System.out.println("||                                                                       ||");
		System.out.println("||Su pokemon para el combate es: "+ jugador.getPokedex().getPokemon(op-1).getNombre());
        System.out.println("||Un "+  player2.getNombre()+ " salvaje a aparecido                        ");
        System.out.println("||                                                                       ||");
		System.out.println("***************************************************************************");
		combates[combateActual] = new Combate(jugador.getPokedex().getPokemon(op-1), player2,indexRiva);
		int rival = combates[combateActual].combatir();

		if (rival > -1){
			System.out.println("||                                                                       ||");
            System.out.println("||Deseas capturar el pokemon ?, [si/no]                                  ||");
            System.out.println("||                                                                       ||");
            try{
                respuesta=buffer.readLine();
            }catch(IOException e){
            	System.out.println("||                                                                       ||");
                System.out.println("||Error de lectura desde el teclado...                                   ||"); 
                System.out.println("||                                                                       ||");
            }
                    
            if(respuesta.equals("si")){
            	System.out.println("||                                                                       ||");
                System.out.println("||Haz lanzado una Pokeball                                               ||");
                System.out.println("||...                                                                    ||");
                System.out.println("||..3                                                                    ||");
                System.out.println("||..2                                                                    ||");
                System.out.println("||..1                                                                    ||");
                System.out.println("||PUFF!                                                                  ||");
                System.out.println("||                                                                       ||");
				jugador.getPokedex().capturarPokemon(rival);
				System.out.println("||Haz capturado un nuevo pokemon!!!                                      ||");
				System.out.println("||                                                                       ||");
            }
            else{
            	System.out.println("||                                                                       ||");
                System.out.println("||Haz dejado libre a "+player2.getNombre());
                System.out.println("||GreenPeace esta feliz <3                                               ||"); 
                System.out.println("||                                                                       ||");
            }
		}
		combateActual+=1;
	}
    
    public void CombateFinal(){
        System.out.println("***************************************************************************");
        System.out.println("||                                                                       ||");
        System.out.println("||Sanhueza:*se saca el VR*                                               ||");
        System.out.println("||Sanhueza: Bien Muchacho, parece que ya estas listo para terminar       ||");
        System.out.println("||el semestre.                                                           ||");
        System.out.println("||                                                                       ||");
        int n=SetupPokemon.cantidadPokemones;
        Pokemon aux;
        System.out.println("***************************************************************************");
        System.out.println("||Pokedex Personal                                                       ||");
        System.out.println("||======= ========                                                       ||\n");
            
        for(int i=0;i<n;i++){
            aux = jugador.getPokedex().getPokemon(i);
                    
            if(aux.getCapturado())
                System.out.println((i+1)+".- "+aux.getNombre());
        }

        int op=-1;
        int indexRiva=151;
            
        Pokemon player2= pokedexGral.getPokemon(indexRiva);
        boolean flag=false;
        
        do{
        	System.out.println("||                                                                       ||");
            if(flag) System.out.println("||Ingrese una opción válida...                                           ||");
            System.out.println("||Elije tu pokemon para la batalla....                                   ||");
            System.out.println("||                                                                       ||");
            
            try{
                op = Integer.parseInt(buffer.readLine());
                flag=true;
            }catch(IOException e){
            	System.out.println("||                                                                       ||");
                System.out.println("||Error de lectura desde el teclado...                                   ||");
                System.out.println("||                                                                       ||");
            }
        }while((op<0)||(op>n));

        System.out.println("***************************************************************************");
        System.out.println("||                                                                       ||");
        System.out.println("||Su pokemon para el combate es "+ jugador.getPokedex().getPokemon(op-1).getNombre());
        System.out.println("||Sanhueza lanzo un "+  player2.getNombre()+ "\n\n");
        System.out.println("||                                                                       ||");
        System.out.println("***************************************************************************");
        combates[combateActual] = new Combate(jugador.getPokedex().getPokemon(op-1), player2,indexRiva);
        int rival = combates[combateActual].combatirFinal();
        
        if (rival > -1){
        	System.out.println("||                                                                       ||");
        	System.out.println("||Sanhueza: Felicitaciones...Pasaste el semestre, sigue asi muchacho.    ||");
            System.out.println("||bueno chao chao.                                                       ||");
            System.out.println("||*Se sube a la micro y se va*                                           ||");
            System.out.println("||(...)                                                                  ||");
			System.out.println("||(...)                                                                  ||");
			System.out.println("||GOOD ENDING..                                                          ||");
            System.out.println("||                                                                       ||");
		}
		combateActual+=1;
	}
        
	public void mostrarPokedex(){
		this.jugador.listarPokedexPersonal();
	}
}