import java.io.*;

public class Mochila {
    private Personaje jugador;
	private int posion;
	private int superPosion;
	private int megaPosion;
    private int maxPosion;
	private boolean piedraAgua;
	private boolean piedraTrueno;
	private boolean piedraFuego;
	private boolean piedraMagica;
    private BufferedReader buffer;

	Mochila(Personaje jugador,int posion, int superPosion, int megaPosion,int maxPosion, boolean piedraAgua, boolean piedraTrueno, boolean piedraFuego, boolean piedraMagica){
		this.jugador=jugador;
		this.posion=posion;
		this.superPosion=superPosion;
		this.megaPosion=megaPosion;
		this.piedraAgua=piedraAgua;
		this.piedraTrueno=piedraTrueno;
		this.piedraFuego=piedraFuego;
		this.piedraMagica=piedraMagica;
        buffer = new BufferedReader(new InputStreamReader(System.in));
	}

	public void menu(){

		System.out.println("***************************************************************************");
		System.out.println("||                      BIENVENIDO A LA MOCHILA                          ||");
		System.out.println("***************************************************************************");
        int op=-1;

		try{
			do{        
				System.out.println("***************************************************************************");
				System.out.println("||Que quieres buscar en la mochila:                                      ||");
				System.out.println("||         | [1] BOTIQUIN     |           | [2] CERRAR MOCHILA |         ||");
				System.out.println("||                                                                       ||");
				op=Integer.parseInt(buffer.readLine());
				System.out.println("***************************************************************************");
				
				switch(op){
					case 1: System.out.println("***************************************************************************");
							System.out.println("||                              BOTIQUIN                                 ||");
							System.out.println("***************************************************************************");
							botiquin();
							System.out.println("***************************************************************************");
							break;

					case 2: System.out.println("***************************************************************************");
							System.out.println("||                         SE CERRO MOCHILA                              ||");
							System.out.println("***************************************************************************");
							System.out.println("||Asegurate de cerrar bien tu mochila para no perder nada.               ||");
	                        System.out.println("||presione ENTER asegurar la mochila y continuar.                        ||");
							break;
				}
			}while(op!=2);
		}catch(IOException e){
			System.out.println("||                                                                       ||");
			System.out.println("||Error de lectura desde el teclado...                                   ||");
			System.out.println("||                                                                       ||");
		}
	}

	public void botiquin(){
		this.posion = 5;
		this.superPosion = 15;
		this.megaPosion = 20;
		this.maxPosion = 100; 
		int opbot=0;
        Pokemon aux;
        int opcion=-1;
        int n=SetupPokemon.cantidadPokemones;

		try{
			do{
				System.out.println("***************************************************************************");
				System.out.println("||Que quieres utilizar:                                                  ||");
				System.out.println("||       | [1] POSION           |           | [2] SUPERPOSION    |       ||");
				System.out.println("||       | [3] MEGAPOSION       |           | [4] MAXPOSION      |       ||");
				System.out.println("||       | [5] CERRAR BOTIQUIN  |                                        ||");
				opbot = Integer.parseInt(buffer.readLine());
				System.out.println("***************************************************************************");
				
				switch(opbot){
					case 1: System.out.println("***************************************************************************");
	                        for(int i=0;i<n;i++){
	                            aux = jugador.getPokedex().getPokemon(i);
	                            
	                            if(aux.getCapturado()==true)
	                                System.out.println((i+1)+".- "+aux.getNombre());
	                        }
	                        
	                        boolean flag=false;
	                        do{
	                        	System.out.println("||                                                                       ||");
	                            if(flag) System.out.println("||Ingrese una opcion valida...                                           ||");
	                            System.out.println("||Elija su Pokemon para ser curado                                       ||");
	                            System.out.println("||                                                                       ||");
	                            
	                            try{
	                                opcion = Integer.parseInt(buffer.readLine());
	                                flag=true;
	                            }catch(IOException e){
	                            	System.out.println("||                                                                       ||");
	                                System.out.println("||Error de lectura desde el teclado...                                   ||");
	                                System.out.println("||                                                                       ||");
	                            }
	                        }while((opcion<0)||(opcion>n));

	                        System.out.println("***************************************************************************");
	                        System.out.println("||                                                                       ||");
	                        System.out.println("||se curara el pokemon: "+ jugador.getPokedex().getPokemon(opcion-1).getNombre());
							System.out.println("||Haz usado una POSION.                                                  ||");
							System.out.println("||                                                                       ||");                        
							System.out.println("||Tu pokemon a recuperado.."+posion+"PS. Ahora tu pokemon tiene.."+jugador.getPokedex().getPokemon(opcion-1).getPs_max()+" + "+(posion)+"PS.");
	                        jugador.getPokedex().getPokemon(opcion-1).setPs(posion);
							System.out.println("***************************************************************************");
							break;

					case 2: System.out.println("***************************************************************************");
							for(int i=0;i<n;i++){
	                            aux = jugador.getPokedex().getPokemon(i);
	                            
	                            if(aux.getCapturado()==true)
	                                System.out.println((i+1)+".- "+aux.getNombre());
	                        }
	                        
	                        flag=false;
	                        do{
	                        	System.out.println("||                                                                       ||");
	                            if(flag) System.out.println("||Ingrese una opcion valida...                                           ||");
	                            System.out.println("||Elija su Pokemon para ser curado                                       ||");
	                            System.out.println("||                                                                       ||");
	                            try{
	                                opcion = Integer.parseInt(buffer.readLine());
	                                flag=true;
	                            }catch(IOException e){
	                            	System.out.println("||                                                                       ||");
	                                System.out.println("||Error de lectura desde el teclado...                                   ||");
	                                System.out.println("||                                                                       ||");
	                            }
	                        }while((opcion<0)||(opcion>n));
	                        
	                        System.out.println("***************************************************************************");
	                        System.out.println("||                                                                       ||");
	                        System.out.println("||se curara el pokemon: "+ jugador.getPokedex().getPokemon(opcion-1).getNombre());
							System.out.println("||Haz usado una SUPER POSION.                                            ||");
	                        System.out.println("||                                                                       ||");                        
							System.out.println("||Tu pokemon a recuperado.."+superPosion+"PS. Ahora tu pokemon tiene.."+jugador.getPokedex().getPokemon(opcion-1).getPs_max()+" + "+(superPosion)+"PS.");
	                        jugador.getPokedex().getPokemon(opcion-1).setPs(superPosion);
							System.out.println("***************************************************************************");
							break;

					case 3: System.out.println("***************************************************************************");
							for(int i=0;i<n;i++){
	                            aux = jugador.getPokedex().getPokemon(i);
	                                                
	                            if(aux.getCapturado()==true)
	                            	System.out.println((i+1)+".- "+aux.getNombre());
	                        }
	                        
	                        flag=false;
	                        do{
	                        	System.out.println("||                                                                       ||");
	                            if(flag) System.out.println("||Ingrese una opcion valida...                                           ||");
	                            System.out.println("||Elija su Pokemon para ser curado                                       ||");
	                            System.out.println("||                                                                       ||");
	                            
	                            try{
	                                opcion = Integer.parseInt(buffer.readLine());
	                                flag=true;
	                            }catch(IOException e){
	                            	System.out.println("||                                                                       ||");
	                                System.out.println("||Error de lectura desde el teclado...                                   ||");
	                                System.out.println("||                                                                       ||");
	                            }
	                        }while((opcion<0)||(opcion>n));
	                        
	                        System.out.println("***************************************************************************");
	                        System.out.println("||                                                                       ||");
	                        System.out.println("||se curara el pokemon: "+ jugador.getPokedex().getPokemon(opcion-1).getNombre());
							System.out.println("||Haz usado una MEGA POSION.                                             ||");
	                        System.out.println("||                                                                       ||");                        
							System.out.println("||Tu pokemon a recuperado.."+megaPosion+"PS. Ahora tu pokemon tiene.."+jugador.getPokedex().getPokemon(opcion-1).getPs_max()+" + "+(megaPosion)+"PS.");
	                        jugador.getPokedex().getPokemon(opcion-1).setPs(megaPosion);
							System.out.println("***************************************************************************");
							break;

					case 4: System.out.println("***************************************************************************");
							for(int i=0;i<n;i++){
	                            aux = jugador.getPokedex().getPokemon(i);
	                            
	                            if(aux.getCapturado()==true)
	                            System.out.println((i+1)+".- "+aux.getNombre());
	                        }
	                        
	                        flag=false;
	                        do{
	                        	System.out.println("||                                                                       ||");
	                            if(flag) System.out.println("||Ingrese una opcion valida...                                           ||");
	                            System.out.println("||Elija su Pokemon para ser curado                                       ||");
	                            System.out.println("||                                                                       ||");
	                            
	                            try{
	                                opcion = Integer.parseInt(buffer.readLine());
	                                flag=true;
	                            }catch(IOException e){
	                            	System.out.println("||                                                                       ||");
	                                System.out.println("||Error de lectura desde el teclado...                                   ||");
	                                System.out.println("||                                                                       ||");
	                            }
	                        }while((opcion<0)||(opcion>n));

	                        System.out.println("***************************************************************************");
	                        System.out.println("||                                                                       ||");
	                        System.out.println("||se curara el pokemon: "+ jugador.getPokedex().getPokemon(opcion-1).getNombre());
							System.out.println("||Haz usado una MAX POSION.                                              ||");
	                        System.out.println("||                                                                       ||");                        
							System.out.println("||Tu pokemon a recuperado.."+maxPosion+"PS. Ahora tu pokemon tiene.."+jugador.getPokedex().getPokemon(opcion-1).getPs_max()+" + "+(maxPosion)+"PS.");
	                        jugador.getPokedex().getPokemon(opcion-1).setPs(maxPosion);
							System.out.println("***************************************************************************");
							break;

					case 5: System.out.println("***************************************************************************");
							System.out.println("||                         SE CERRO BOTIQUIN                             ||");
							System.out.println("***************************************************************************");                    
							break;
				}
			}while(opbot!=5);
		}catch(IOException e){
			System.out.println("||                                                                       ||");
			System.out.println("||Error de lectura desde el teclado...                                   ||");
			System.out.println("||                                                                       ||");
		}
	}	
}