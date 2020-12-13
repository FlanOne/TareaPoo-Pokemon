import java.math.*;
import java.io.*;

public class Combate{
	private Pokemon player1;
	private Pokemon player2;
	private int indexRival;
	BufferedReader buffer;

	Combate(Pokemon player1, Pokemon player2,int indexRival){
		buffer = new BufferedReader(new InputStreamReader(System.in));
		this.player1 = player1;
		this.indexRival=indexRival;
        this.player2= player2;
	}

	public void ataque(Pokemon player1,Pokemon player2){
		int op;
		try{
            System.out.println("||                                                                       ||");
			System.out.println(player1.getNombre()+", El ataque sera: ");
			System.out.println("||1.-"+player1.getAtaques()[0].getNombre());
			System.out.println("||2.-"+player1.getAtaques()[1].getNombre());
			System.out.println("||3.-"+player1.getAtaques()[2].getNombre());
			op = Integer.parseInt(buffer.readLine());

            System.out.println("***************************************************************************");
            System.out.println("||                                                                       ||");
            System.out.println(player1.getNombre()+" uso "+player1.getAtaques()[op-1].getNombre());
            System.out.println("||                                                                       ||");
            System.out.println("***************************************************************************");

            if(op==1 || op==2){
                player2.recibirAtaque(player1.getAtaques()[op-1], player1);
                System.out.println("***************************************************************************");
                System.out.println("||                                                                       ||");
                System.out.println(player2.getNombre()+" tu nivel de Puntos de Salud es "+player2.getPs());
                System.out.println("||                                                                       ||");
                System.out.println("***************************************************************************");
            }
            else {
                player1.AumentarStats(player1.getAtaques()[op-1]);
                System.out.println("***************************************************************************");
                System.out.println("||                                                                       ||");
                System.out.println(player1.getNombre()+" tu defensa aumento a: "+player1.getDefensa());
                System.out.println("||                                                                       ||");
                System.out.println("***************************************************************************");
            }

		}catch(IOException e){
			System.out.println("||                                                                       ||");
			System.out.println("||Error de lectura desde el teclado...                                   ||");
			System.out.println("||                                                                       ||");
		}
	}

    public void IA(Pokemon player1,Pokemon player2){
		int op=(int)Math.round(Math.random()*2);
        System.out.println("||                                                                       ||");        
		System.out.println(player1.getNombre()+" uso: "+player1.getAtaques()[op].getNombre());
		System.out.println("||                                                                       ||");

        if(op==0 || op==1){
            player2.recibirAtaque(player1.getAtaques()[op], player1);
            System.out.println("***************************************************************************");
            System.out.println("||                                                                       ||");
            System.out.println(player2.getNombre()+" tu nivel de Puntos de Salud es "+player2.getPs());
            System.out.println("||                                                                       ||");
            System.out.println("***************************************************************************");
        }
        else {
            player1.AumentarStats(player1.getAtaques()[op]);
            System.out.println("***************************************************************************");
            System.out.println("||                                                                       ||");
            System.out.println(player1.getNombre()+" su defensa aumento a: "+player1.getDefensa());
            System.out.println("||                                                                       ||");
            System.out.println("***************************************************************************");
        }        
    }

	public int combatir(){
		int out=0;
		boolean sigue=true;

		while(sigue){
			ataque(player1,player2);

			if(revisarTriunfo(player2)){
                player1.ganarEXP(revisarTriunfo(player2));
				System.out.println("***************************************************************************");
				System.out.println("||                                                                       ||");
				System.out.println("||Felicitaciones...Haz ganado la partida!!                               ||");
				System.out.println("||                                                                       ||");
				System.out.println("***************************************************************************");
				System.out.println("||                                                                       ||");
                System.out.println("||has ganado esta EXP: 25                                                ||");
                System.out.println("||                                                                       ||");
				out = indexRival;

	            if(player1.NextLevel()==true){
	            	System.out.println("||                                                                       ||");
	                System.out.println("||Felicidades UwU... tu pokemon a subido de nivel. *CLAP* *CLAP*         ||");
	                System.out.println("||                                                                       ||");    
	            }

				player1.restaurar();
	            player1.retornarStats();
				player2.restaurar();
	            player2.retornarStats();
	                                
	            if(player1.Evolucion()==true){
	            	System.out.println("||                                                                       ||");
	                System.out.println("||OJOOOO OwO... tu pokemon evoluciono en un: "+player1.getNombre());
	                System.out.println("||Felicidades chaval se mota que te enseno el Claudio <3                 ||");
	                System.out.println("||                                                                       ||");                  
	            }
				break;
			} 
			IA(player2,player1);

			if(revisarTriunfo(player1)){
                player1.ganarEXP(revisarTriunfo(player2));
				System.out.println("***************************************************************************");
				System.out.println("||                                                                       ||");
				System.out.println("||Haz perdido la partida!!                                               ||");
				System.out.println("||                                                                       ||");
				System.out.println("***************************************************************************");
				System.out.println("||                                                                       ||");
                System.out.println("||has ganado esta EXP: 15                                                ||");
                System.out.println("||                                                                       ||");
                System.out.println("***************************************************************************");
                System.out.println("||                                                                       ||");
                System.out.println("||Como tu pokemon se debilito en el combate, lo llevaste al centro       ||");
                System.out.println("||pokemon mas cercano para que se recuperara.                            ||");
                System.out.println("||                                                                       ||");

                if(player1.NextLevel()==true){
	            	System.out.println("||                                                                       ||");
	                System.out.println("||Felicidades UwU... tu pokemon a subido de nivel. *CLAP* *CLAP*         ||");
	                System.out.println("||                                                                       ||");    
	            }

	            if(player1.Evolucion()==true){
	            	System.out.println("||                                                                       ||");
	                System.out.println("||OJOOOO OwO... tu pokemon evoluciono en un: "+player1.getNombre());
	                System.out.println("||Felicidades chaval se mota que te enseno el Claudio <3                 ||");
	                System.out.println("||                                                                       ||");                  
	            }
	            
				out = -1;
				player1.restaurar();
                player1.retornarStats();
				player2.restaurar();
                player2.retornarStats();
				break;
			}
		}
		return out;
	}

    public int combatirFinal(){
		int out=0;
		boolean sigue=true;

		while(sigue){
			ataque(player1,player2);

			if(revisarTriunfo(player2)){
                player1.ganarEXP(revisarTriunfo(player2));
				System.out.println("***************************************************************************");
				System.out.println("||                                                                       ||");
				System.out.println("||Sanhueza: Felicitaciones...Pasaste el semestre, sigue asi muchacho.    ||");
				System.out.println("||(...)                                                                  ||");
				System.out.println("||(...)                                                                  ||");
				System.out.println("||GOOD ENDING..                                                          ||");
				System.out.println("||                                                                       ||");
				System.out.println("***************************************************************************");
                System.out.println("||has ganado esta EXP: 25                                                ||");
				out = indexRival;

                if(player1.NextLevel()==true){
                	System.out.println("||                                                                       ||");
                    System.out.println("||Felicidades UwU... tu pokemon a subido de nivel. *CLAP* *CLAP*         ||");
                    System.out.println("||                                                                       ||");              
                }
				player1.restaurar();
                player1.retornarStats();
				player2.restaurar();
                player2.retornarStats();
                                
                if(player1.Evolucion()==true){
                	System.out.println("||                                                                       ||");
                    System.out.println("||OJOOOO OwO... tu pokemon evoluciono en un: "+player1.getNombre());
                    System.out.println("||Felicidades chaval se nota que te enseno el Claudio <3                 ||");
                    System.out.println("||                                                                       ||");        
                }
				break;
			} 
			IA(player2,player1);

			if(revisarTriunfo(player1)){
                player1.ganarEXP(revisarTriunfo(player2));
				System.out.println("***************************************************************************");
				System.out.println("||                                                                       ||");
				System.out.println("||Sanhueza: Parece que te paso la micro encima                           ||");
				System.out.println("||Sanhueza: Nos vemos el siguiente semestre muchacho, a ver si lo logras ||");
				System.out.println("||Sanhueza: en una proxima revancha.                                     ||");
				System.out.println("||(...)                                                                  ||");
				System.out.println("||(...)                                                                  ||");
				System.out.println("||BAD ENDING..                                                           ||");
				System.out.println("||                                                                       ||");
				System.out.println("***************************************************************************");
				System.out.println("||                                                                       ||");
                System.out.println("||has ganado esta EXP: 15                                                ||");
                System.out.println("||                                                                       ||");
                System.out.println("***************************************************************************");
                System.out.println("||                                                                       ||");
                System.out.println("||Como tu pokemon se debilito en el combate contra el mastreo pokemon    ||");
                System.out.println("||Sanhueza , lo llevaste al centro pokemon mas cercano para que se       ||");
                System.out.println("||recuperara.                                                            ||");
                System.out.println("||                                                                       ||");
				out = -1;
				player1.restaurar();
                player1.retornarStats();
				player2.restaurar();
                player2.retornarStats();
				break;
			}
		}
		return out;
	}

	public boolean revisarTriunfo(Pokemon player){
		if(player.getPs()<=0) return true;
		else return false;
	}
}