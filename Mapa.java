import java.io.*;

public class Mapa {
    private BufferedReader buffer;
	private Combate [] combatesMapa;
	private int combateActualMapa;
	private Pokedex pokedexGral;
    private int visit1=0;
    private int visit2=0;
    private int visit3=0;
    private int visit4=0;
    private int visit5=0;
    boolean maradona=false;

	Mapa(Pokedex pokedexGral){
		buffer = new BufferedReader(new InputStreamReader(System.in));
		combatesMapa = new Combate[SetupPokemon.cantidadCombates];
		combateActualMapa = 0;
		this.pokedexGral = pokedexGral;               
	}

    public boolean getMaradona(){
        return this.maradona;  
    }

    public int Visitado( int visit){
        visit=visit+1;   
        return visit;   
    }

	public void menuMapa(){
		int op=0;
                
		System.out.println("***************************************************************************");
		System.out.println("||                        BIENVENIDO AL MAPA                             ||");
		System.out.println("||                 No nos hacemos cargo si te pierdes                    ||");
		System.out.println("***************************************************************************");

		try{
			do{
				System.out.println("***************************************************************************");
				System.out.println("||A que parte del mapa quieres ir:                                       ||");
				System.out.println("||       | [1] PARQUE ALMAGRO  |            | [2] POLIDEPORTIVO |        ||");
				System.out.println("||       | [3] EDIFICIO VK1    |            | [4] LETIC         |        ||");
				System.out.println("||       | [5] OFICINA DEL SANHUEZA  |      | [6] CERRAR MAPA   |        ||");
	            System.out.println("||                                                                       ||");
				op = Integer.parseInt(buffer.readLine());
				System.out.println("***************************************************************************");

				switch(op){
							case 1: System.out.println("\n***************************************************************************");
                                    visit1=Visitado(visit1);
                                    LlaveFinal(op);
                                                
									System.out.println("||                   AHORA ESTAS EN PARQUE ALMAGRO                       ||");
									System.out.println("***************************************************************************");
									System.out.println("||'Tienes vagos recuerdos de este lugar... por alguna razon te da sed??' ||");
									System.out.println("||(...)                                                                  ||");
									System.out.println("||Que quieres hacer?:                                                    ||");
									System.out.println("***************************************************************************");
                                    
                                    if(visit1>=2){
                                        System.out.println("||Usted ya ha visitado PARQUE ALMAGRO                                    ||");          
                                    }
                                    op=6;
									break;

							case 2: System.out.println("\n***************************************************************************");
			                        visit2=Visitado(visit2);
			                        LlaveFinal(op);
									System.out.println("||                    AHORA ESTAS EN POLIDEPORTIVO                       ||");
									System.out.println("***************************************************************************");
									System.out.println("|| 'Es un ambiente muy animado jeje, pero deberias irte antes de que...' ||");
									System.out.println("|| '*Te llega un pelotazo en la cara*'                                   ||");
									System.out.println("||(...)                                                                  ||");
									System.out.println("|| 'Trate de advertirte D:'                                              ||");
									System.out.println("||(...)                                                                  ||");
									System.out.println("||Que quieres hacer?:                                                    ||");
									System.out.println("***************************************************************************");
			                        
			                        if(visit2>=2){
			                            System.out.println("||Usted ya ha visitado POLIDEPORTIVO                                     ||");                      
			                        }
			                        op=6;
									break;

							case 3: System.out.println("\n***************************************************************************");
			                        visit3=Visitado(visit3);
			                        LlaveFinal(op);
									System.out.println("||                     AHORA ESTAS EN EDIFICIO VK1                       ||");
									System.out.println("***************************************************************************");
									System.out.println("||'Este lugar te hace sentir mas ingenioso de lo normal... y tambien   ' ||");
									System.out.println("||'cansado mentalmente..' ||");
									System.out.println("||(...)                                                                  ||");
			                        System.out.println("||Que quieres hacer?:                                                    ||");
									System.out.println("***************************************************************************");
			                                                 
			                        if(visit3>=2){
			                            System.out.println("||Usted ya ha visitado el EDIFICIO VK1                                   ||");  
			                        }
			                        op=6; 
									break;

							case 4: System.out.println("\n***************************************************************************");
			                        visit4=Visitado(visit4);
			                        LlaveFinal(op);
									System.out.println("||                        AHORA ESTAS EN LETIC                           ||");
									System.out.println("***************************************************************************");
									System.out.println("||'Dios esta muy oscuro y frio aqui!... me da escalofrios...'            ||");
									System.out.println("||'no me gustan los pokemones tipo fantasma asi que espero que no me en-'||");
									System.out.println("||'cuentre con uno de ellos aqui'                                        ||");
									System.out.println("||(...)                                                                  ||");
									System.out.println("||Que quieres hacer?:                                                    ||");
									System.out.println("***************************************************************************");
			                                                 
			                        if(visit4>=2){
			                            System.out.println("||Usted ya ha visitado el LETIC                                          ||");                   
			                        }
			                        op=6;
									break;

							case 5: System.out.println("\n***************************************************************************");
			                        visit5=Visitado(visit5);
			                        LlaveFinal(op);
									System.out.println("||                 AHORA ESTAS EN OFICINA DEL SANHUEZA                   ||");		                                                
									System.out.println("***************************************************************************");
                                    System.out.println("odxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddo\n" +
"dkKXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK00000KKKKKKKKKKKKXXXXKKKKXKKKKKKXXKKKXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK0kd\n" +
"dkXNNNNXXXXNNNXXXXXXXXXXKXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKK00KKXXXXXXXXXXXXXXXXXXXXXXXNNNNXXXXXXXXXXXXXXNNXXXXXXXXXXKKKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKXXX0ko\n" +
"dOXNNNNXXXXNNXXXXXXXXXXXKKXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKK00KKXXXXXXXXXXXXXXXXXXXXXK00OOOOkxxxxxxkkkkkO00KKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKXX0kd\n" +
"dOKNNNNNXXXXNNNNNXXXXXXXXXXXXXXXXXXXXXKXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKXXXXXXXXXXXKXXXXK0Okdolc:::;;,,,'',,,;;;;::cloxkOKXXXNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKXKkd\n" +
"dkKNNNNXXXXXXXNNXXXXXXXXKKXXXXXXXXXKKKKKKKKKKKKKXKKKKKKKKKKKKKKKKKKKKXXXXXXKKKKKKK0Okdl:,''........................'';coxOKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKXKko\n" +
"okKNNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKXXKKKXXXKK0kxdooodolc:,'.................................,:oxOKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK0ko\n" +
"okXNNNXXNNNNNNXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKK00OOkxoc:,'...'''''.......................................,:lxOKXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKXXKK0ko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKK0000OOkxoolc;,'......................................................';cok0KXXXXKKXXXXXXXXXXXXXXXXXXXXKKXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKXXKKKkd\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKK00Okdoccc:;,'.........''...................................................';lk0XXXKKXXXXXXXKXXXXXXXXXXXXKKXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKXXKKKkd\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKOxdol:;'''''...'''''.........................................................,cdk0XXNXXXXXXKKKKXXXXXXXXXXKKXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKXXKKKkd\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKXXXK0Oxolc:;,,'.....''''.......',,,''................................................,cdOKKXXXXXKKKKKKKXXXXXXXXKKXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKXXKKKkd\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKXXXXXXXXXXXXKK0Okdoc;,''''.....''''''',;;;:::::;;;;;;,,,,;:::;;,,,,,,''.............. ............,cdOKXXXXKKXXXXXXXXXXXXXKKKXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKXXKKKkd\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKXXXXXXXXXXXKK0O0Oxc;,,,''''''...',;:clloooooolllllloolcclodddoolllccc::;,,''''''''..................,cdOKXNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKXXKKKkd\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKXXXXXXXXXXXXK0OOxo;',,;,''',,;::cloodddddxxxxddddddddolloxxkkxxxddoolllcccc:::;;;;;;;,,'........ ......;lx0XXXXXXXXXXKXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKXXKKKkd\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKXXXXKKKXXXXXK0xl:,'',,'',,;coddddooddxxxxxxxxxxxxxxxxdooododdxxxxxxxdddooollllllccc:ccc::;'....   ....  ..;oxOKNNXXXXXKXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKXXKKKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKXXXXKKXXXXXX0d:'.',,,,',:loxxxxxxxxxkkkkkkkkkkkxxxxxkkkxdolllooddxxxxxxxdddooooooollllllllcc;'...  ...... ..':okKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKXKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKXXX0d:..',;,'';coxxkkkkkkkkkOOOOOOkOOOkkkxxkkkOOkkxxxxxxxxkkkkkxxxxxddddddooooooooollc;'...............,lOKXXXXXXKKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKXKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKXXKkl;''','',;coxxkkkkkkkkOOOOOOOOOOOOOOkkkkkkkkkkOOOOkkkkkkkkkkkkkxxxxxxxddoooodddooool:;'......''......':d0XXXXXKKKKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKXKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXKXXXKKXXXXKK0xc,.',,'.':okOkkkOOkOOOOOOOOOOOOO00OOOOOOOOOOkkkOOOOOOkkkkkkkkkkkkkxxxxxxdddddddddoolllc:;,'....''.......'ckKXXXKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKXKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKXXXXKkxdc;,'...';cdkOOOOO0OOO00000OOOO0000000OOO00000OOOOOOOOOOkkkkkkkkkkkkxxxxxxxxdddddddoooolcc:;,'...'''..''....;d0XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKXKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXKXXXNXKOxolc;,'...':okOOOOO000000000000000000000000000000OOOOOO0OOOOOkkkkkkkkkkkkkkxxxxxxxxddddddolcc:;;,,''''.....''...'ckKXXKKKKXXXKKKXXXXXXXXXXXXXXXXXXXXXXXKKKKXKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXKKKXXNXKkolc:,'....;lxO0000OO0000000000000000000000K0000000OOOOOOOOOOOOOkkkkkkkkkkkkxxxxxxxxxddddddoollc::;;;,,''.....''...';oOKXXXXXXXKKKXXXXXXXXXXXXXXXXXXXXXXXKKKKXKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXKKXXXX0xoc:,....':okO00000O000000000KKKK0000000000KKK00000OOOOOOOOOOOOOkkkkkkxkkkkxxxxxxxxddddxxddooollc::::::;,,,,,,,''....':xKNXXXXXKKKKXXXKKKKXXXXXXXXXXXXXXXKKXKXKko\n" +
"dOXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXKXXXXKOko:'...,cdO00000000000000000KKKKKK00000000000000000OOOOOOOOOOOOkkkkkkkkxxxxxxxxxxxxdddxxxdddoollc:ccllc:;,,,,,,''.....:xKXNXXXKKKKXXXXKKKXXXXXXXXXXXXXXXKKXXXKko\n" +
"dOXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKXXX0dc;''';cdkO0000000000000000KKKKKK0000000000000000000OOOOOOOOOOkkkkkkkkkkkkxxxxxxxxxxxddddddddooolcc::cclc;,',;;;;;;;'.,ckKNXXXXXXKXXXXKKXXXXXXXXXXXXXXXXKKXXXKko\n" +
"dOXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKXXKxc;,,;;cdkO000000000000000000000000000000000000000000OOOOOOOOOOkkkkkkkkkkkkkxxxxxxxxxxxdddddddoooolc:;:::c:::;;:::ccc:,',lOKXXXXXXXKKKKKKKXXXXXXXXXXXXXXXKKXXXKko\n" +
"dOXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXKXXXXX0d:;:::coxO000OO00000000000000000000000000000000000000OOOOOOOOOOOOOOOkkkkkkkkkkxxxddxxxxxddddddddollcccc:::::::;;;,,;;;,..,lOKXXXKXXXKKKKXXXXXXXXXXXXXXXXXKKXKXKko\n" +
"dOXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXKKXXXXOo:::::ldkO000O000000000000000000000000000000000000000000000OOOOOOOOOOOOkkkkkkkkxxdddxxxxxxddxxxdoollcccccc:;;:::;'.',;:;'':dKXXKKKXXXKKXXXXXXXXXXXXXXXXXXKKKKXKko\n" +
"dOXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXKKXXKko:;;;:lxOO00000000000000000000000000000000OOO00000000000000000OOOOOOOOOOkkkkkkkkxxxxxxxxxxxxxddddxxdolcclc;,,;:cc:;,',,;;,;o0XNXKKXKKKKKXXXXXXXXXXXXXXXXXKKKKXKko\n" +
"dOXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXKKXKkl:;,;:ldkOO0000000000000000000000000000000000000000KKK0000000000OOOOOOOOkkkkkkkkkkkxxxxxxxxxxxddddxxddlc:::;''',:ccc;'.',;,,ckKXXXKKKKKKXXXXXXXXXXXXXXXXXXKKKKXKko\n" +
"okXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKd:,,;:loxkO000000000000000KKKKKKKK000000000000000000KKKK00000000OOOOOOOOOOkkkkxxdxxxkkxxxxxxxxxxxxddddddolc:;''',;:::;,,,,,..;oOXXXXKKKXXXXXXXXXXXXXXXXXXXXKKXKXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX0dc:cclloxkO000000O00000000KKKKKKKK000KKKK00000000000KKKK0O0000OOOOOOOOkkkxddddolllloodxxxxxxxxxdxxxddddddool:;,,,,;;:;;;,,,'.,ckXNXXXXXXKKXXXXXXXXXXXXXXXXXKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXXXXXXXXKXXXXKxcccllodxkOO00000O0000000KKK0000KKKKKKKK0000000KKK000000OOOOOOkkkxxdoolc:;,;;::::;;;;::cllodxxxxxxddddddddolc::;;;;;;;;;;;;,,;cxKNXXXXXXKKKKXXXXXXXXXXXXXXXKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKxlccccldkOO000000000000KKKKK0000KKK000000OOOOO00000OOOOOkkkkkkxdoc;,'....   ...'',''..'',,:codxxxxxdddddddoolc:;,;:::;,,,;;;;;cxXNXXKXXXXXXXXXXXXXXXXXXXXXXKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX0xolcccldkO0000000000000000000000000OOOOOOOkkkkkO000OOOkkxdololcc:,.........'',;;;;;,,'',,,;:cloddddddddddddooc:,,,;::;''',,,'';dKNXXKXXXXKKKXXXXXXXXXXXXXXXKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKK0xlcccclxO000000000000OOOkkkkxxddooolllloooooodxkO000OOkkdol:::;;,,,,,;;:lodkOOOkkxxdollccc::cclooodddddddddool:;,,,;;;,'',,,'';dKNXXXXXXKKKKXXXXXXXXXXXXXXXKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXXXXXXXXKKXXXKxlccccdk00000000KK0OOkxdolc:;,'......',,;;;:cldxO00OOOkkdolc:::;::cloodxkkO000OOkkkkxxddooolllllloooddddddooolc;,,;::;,'''',,,cxKXXXXXKKKXXXXXXXXXXXXXXXXXXKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKkocccldO000000KK0Oxddolc:,'..........',,;;;;:ldkO0OOOOkkxdolcccclodxdddxxkkkkxdollllllloooooolllooodddddddooool:,,;:c:,'..',:coOXXXXXXKKXXXXXXXXXXXXXXXXXXXKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKkolllldkO0000K0Oxolc:::::::::cclllllllllllccldxO000OOOOkkxdollooddddodddddolc;,'...';;;;:clllooooddddddddddoool:,,,::::;,;:clldkKXXXXKKXXXKKXXXXXXXXXXXXXXXKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKXXXXXXXXXXKOdllodxO00000K0OxolcccloxkOO0000OkxxddddddoodxkkO00000OOkxolclooddolooollll:'...  .;lc;'',:clloddxxxxdddddddool:;,,,;;:clooc:;:okKXXXKKXXXKXXXXXXXXXXXXXXXXKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKXXXXXXKXXXX0xolloxkO000000OxdddxxkOOO0000OOkxdoolloooooddxkO00KK000Okdlccllodool::cd00x;.. ..;oxoc,',;:loddxxxxxxxxxdddoolc:;;,',;coooc;,,:okKXXXKXXXKXXXXXXXXXXXXXXXXKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKXXXXXXXXXXX0koc:ldkO0000OOkxxxkOOOOkxxdddddolccccccccclodxkO0KKKK00Okdoccodxxdl::cok0K0xl;,,:lodlc:::cllodxkkkkxxxxxdddoooc:::;,;:lddoc:,',:dOXXXXKXXXKXXXXXXXXXXXXXXXXXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKXXXXXXXXKKXKOdc:coxO00000OkkxkOOkxdooc:,'.....';cc:::cldxkkO00KKK00OkxoccodxxdoodxxkOOOOkxooooooolcllooodxxkkkkxxxxdddddolc::::::coddolc;,';okKNXXXXXXKXXXXXXXXXXXXXXXXXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKXXXXXXXXXXXXKkoccldk00000OOkkOOxoc::cll;...  .,lddlccldxOOOO000KKK0Okxdolloodxkkxddddxdddoooollollooddddxxkkkkkxxxxdddddolc::;;;:clooolc:,';lkKXXXXXXKXXXXXXXXXXXXXXXXXXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKXXXXXXXXXXXXXOdl:cok00000OOOOOxl;',lxOOd:'...,lxOkxddddxOOOOO00KKK0Okxxdoooooxkkkxdddooodddooooodddxxkkxkkkkkkxxxxddddoooolc:;,,;:looool:,',lkKXXKKXXXXXXXXXXXXXXXXXXXXXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKXXXXXXXXXKKXXKOoc:cx00000000OOkdc:coxO0OxdolodxkkxooooxkOOOOO00K0000OkxdddddddxkOOOkkxxxxkkxxxkkkkkkkOOkkkkkkxxxxxxddooooool:;,;;;;:codl:,';lkKXXKKXXXXXXXXXXXXXXXXXXXXXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKXXXXXXXXXKKXXKOxlccdO000000000OkxxdxxxkkkOkkkxdolllloxkO0OOO00KK0000OOkxxddddodxkOOOOOOkkOOOOOOOOOOOOOOOOkkkkxxxxxxdddooooolc;;::;,';looc,';oOKXXXKKKXXXXXXXXXXXXXXXXXXXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKKXXXXKKKKKKXKkooolcdO0000000000000OkkkkkxxxdddollodkO00000000KKKKKK00OkxddddddddxkOOOOOOOOOOOOOOOOOOOOOOOkkkkkxxxdddddoooloolllllc;'';loc;,;o0XXXXXKXXXXXXXXXXXXXXXXXXXXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKKXXXXXXKXXXX0dccllldO000O00000000000OOkxxddddxxxxkO0KKK000000000KKK00OkxdddddddxxkkOOOOOOOOOOOOOOOOOOOOOOkkkkkxxddddddoolllooooddo:'.';cc:;:dKNNXXXXXXXXXXXXXXXXXXXXXXXXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKKXXXXXXKKXXX0xllolloxO0000000K000000000OOOOOOOOO0000KK00000000000K00OOkkxdddddxxxxkOOkOOOOOOOOOOOOOOOOOkkkkkxxxddddddooooooooooddo:'..';::;:dKXXXXXXXXXXXXXXXXXXXXXXXXKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKKXXXXXXKXXKXKOddolcldkO00000KKK0000KKKKKKKKK0000000000000000000000000OOkxdddddddddxOOOOOOOOOOOOOOOOkkkkkkkxxxxxddddddooooooooooooc;''';:c:;:o0XXXXXXXXXXXXXXXXXXXXXXXXKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKKXXXXXKKXXKKK0kdoolllxO00O0000KK0000KKKKK000000000KKK000O00000000KK000OkkdddddddddxkOOOOOOOOOOOOOOOkkkkkkxxxxxxdddddddoooooooooolc;;:cc::;;:oOKXXXXKKXXXXXXXXXXKKKKKKKKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKKXXXXKKKKKKKXKOkxxdlcokOOOO000000000KKKKKKKKKKKK0000000OOO00000KKKKK00OOkxxdddxxdddxkOOOOOOOOOOOOOOOOOkkxxxxxxdddddddooooooooooolc::cllc:::cxOKXXXKKKXXKKKKKKKKKKKKKKKKXXXXKko\n" +
"okXNNXXXXXXXXXXXXXXXXXXXKKKXXXXKKKXKKKXK0OkkkxdxkkOOOOOO000000KKKKK0KKKKKK00000OOOOO00KKKKKKKKK0OOkkkkxxkkkxddxkOOOOOOOOOOOkkkkkkkxxxddddddddddoooooolloodol:::ccllolokKXXXXXKKKKKKKKKKKKKKKKKKKKXXXXKko\n" +
"okXNNNXXXXXXXXXXXXXXXXXXKKXXXXXKKKXXKXKKK0kkkO00OOOOOOOOO000000000000000KKK000OOOOO000KKKKKKKKK0OkkkkkkkkkkxdodxkOOOOOOOOOOOkkkkkkkxxxxxdddddddooooollllooolc:::cloddxOKXXKKXXXKKKKKKKKKKKKKKKKKKXXXXKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXKXXXKKKXK0kkOKK0OkkOOOOOOOOOO00000OOO0000000OOkO00KK00KKKK000OOkxdollccclodollldOOOOOOOOOOOOOkkkkkkxxxxddddddddooollllllollccclllooxOKXXKKKKKKKKKKKKKKKKKKKKKKKKKXKXKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKXXKOkk000OkkOOOOOOOOOO00000OOO000000OOkkO000Okxxkkkkkxxxdl;......';cc::cokOOOOOOOOOOOOkkkkkkxxxddxxxxddooooooolllolccclooodxO0KXXKKKKKKKKKKKKKKKKKKKKKKKKKKKXKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKXXK0OkOO00OOOOOOOOOOOO00000OO00000OOOkkkkOkdc;',;:cllllc;,'......',,,,;:okOOOOOOOOOOOOkkkkkkxxxdxxxxxddoooooolllooc:;;clodk0KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKXKkd\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKXXK0OkO00OOOOOOOOOOOO000OOO000000OOkkkkkkxl;....',;:::,''''',,,;,,;;;cldkkOOOOOOO0OOOkkkkkkxxxxxxxxxxddooooolllooc;;cokO0KXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKXKkd\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXKKXXXXKKKKKK0OOOOOOOkkOOOOOOOO000OOO000000OOkkkO00Odl:::cllllc:;;::ccccccllooddxxkkkkOOOO000OOkkxkkkkxxxxxxxxxddooolllllol:;cdOKXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKXKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXKKXXXXKKKKKKK0OOOOOOOOOOOOOOOOOOOOOO000000OkkOO0000OkkkOO0OkxdoodxxxdddddxxxxxkkkkkkkkkkOOOOOkkxxxkkxxxxxxxxxxdddoolllllllc:lx0XXKKK00KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKK000000OOOOOOOOOOOOOOOO00000OOOOO00000000000000OkkkOOOOOkkOkkkxxxxxxkkkkxxkkkkOOkkkxxxxxxxddxxxxddddoolllllllclx0KKKKKKKKKKKKKK0000KKKKKKKKKKKKKKKKKKKKK0ko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXKKKKKXKKKKKK00000OOOOOOOOOOOOOOOOO00000OOO0000000OOO000000OkOO000000OOOkkkxxxxxxxkkxxxxkkkkkkkxxxxxddddddddddoollllllllclkKXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK0ko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKXXXKKKKKKKKKKKKK0OOOOOkOOO000OOOOOOOOOO0000000000OOOO0000KKKK00O000000OOOOOOkkkkkkxxxkkkkkkkxxkkkkxxxxxxxddddddddooollllllcclkKXKKKKKKKKKKKKKKKKKKKKKKKK000KKKKKKKKKKK0ko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKXXXXKKKKKKKKKKKK0OOOOkkkOOO00OOOOOO000OOO00000OOO00000KKK0000OOOOOkkxdddddddddxxxkxxxxxxkkkkkxxxkxxxxxxxxddddddddooolllllc:;:dKXKKKKKKKKKK0000000KKKK00000000KKKKKKKKK0ko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKXXXXKKKKKKKKKKKKKKK00OOOOOO0OOOOOOO00OOOO0000OO0000000Okkxxxddddolcc::::::;;;;;::cclccclodxkkxxxxxxxxxxddddoooooooollllllc:;:dKKKKKKKKKK00000000000000000000000KK0KK0K0ko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKXXXXKKKKKKKKKKKKKKKKKK00OOOO0000OOOOO00000OOOOOOO0OOkdolcllllccc:;;;:::::::;;;;;;,,;;,,,;codkkkxxxxxxddddooooooooollllllllclokKKKKKKKK0000000000000000000000000000000K0ko\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKXXKKKKKKKKKKKKKKKKKKKK00OOOOO0000OOO00000OOOOOkxddolc::::clloddxxxxxxkkxxxddddddoooooollclodxxxxxxxxdddoooooolllllllcllccldxO0KKKK0000000000000000000000000000000000000xo\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK00OOOOOO0000000OOOO00Oxl:;;:clodxxkkOO00000OOOOOkxxxdddddddddxxxxkkkkkxxxxxxdddooooooollllllllllccok0KK00000000000000000000000000000000000000000xo\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK00OOOOOOOO00OOO00OOxl:;ldxkOOOOOOOOOkkxxddooooddddoooooodddxxkkkkkkkxxxxxdddooooooooollllllllccldk0KKK0K0000000000000000000000000000000000000Oxo\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKK00KKKKK0OOOOOOOO00OOO0Okxddodk00OOkOOkkkxdolc:::::ccllllllloodxxxxxxxxxxxxxxxxdddoollllooooollllllcccldkOKKKKKK000000000000000000000000000000000000Oxo\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK00OOOOOOO00OOOOOkkxkOO00OOkkkxxdolc:;;;;::cccccccclodxxkxxxxxxxxxddddddddollllllllllllllllcccccldk0K0000000000000000000000000000000000000000Oxo\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK00OOkkOOOOOOOOOOkkOO000OOOOkxxolcc:::clloooooooodxxkkkkkkkxxxxxddooddddoollcccclccccllllccclcclok0K0000000000O00000OO0000000000000000000000Oxo\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK0OkkkkOOOOOOOOOOOOOOOOOOOOOOkxxdddddxkkkkkkkxxkkOOOOOOOOkkxxxdddoddddoolllcccccccccccclccllccldk0KKKKK0000000OO0000000OOOOOOOOOOOOOOOO00O0Oxo\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK00OkkkkOOOOOkkkkkkkOOOOOOOOOOOOOOOO00000OOOOOkkOOOOOOOOOOkkxxdddddddooollcccccccccccccc:cclccldO00OkO0K0000000000000OOOOOOOOOOOOOOOOOOOOO0Oxo\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK00OkkkkkkkkkkkkkkkkkkkkOOOOO000000000000000OOOOOOOOOOOOOkkxxddxxdddoolllccccccccccccccclcc:cok0KOo::lk0K00OO000000OOOOOOOOOOOOOOOOOOOOOO0Oxo\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK000K000OkxxxxkkkkkkkkkkxkkOO0000000000O000000000OOOOkkkkkkkkkxxxxxxddoollccc:::::c::::cc:ccc:;:ok0KK0x:..:d0KK0OO0000000OOOOOOOOOOOOOOOOOOOOOOxo\n" +
"dkXNNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK00000OOkxxxxxkkkkkkkkkOO00000O000000OO000000OOkkkkkkkkkkxxxxxddddollcc:::::::::::::cccc:;;:oO0K00KKd,..;dOKK0OOO000000OOOOOOOOOOOOOOOOOOOOOxo\n" +
"okXNNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKK000KKKKK0000KXK0kdoddxxxkkkkkOOO0000000000000000000Okkkkkkkkkxxxddddddoollc::::::::cc::::::cc:;,,cxOKK000KKxc'..;ok0KK00OOOO0OOO00OOOOOOOOOOOOOOOOOxo\n" +
"okXNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKK000KKK0KKKK000XNWN0xoooodddxxkkOOOOOOOOOO0000O000OOOOOkkkkkxxdoooooolllllcc::;;:::::::cc::::::;'.,lk0K000000ko;....,:lx0KK00000000OOOOOOOOOOOOOOOOOOkxo\n" +
"okXNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK00K000000XWWWXOxddoolloddxxkOOOOOOOkkkOOOOOOOkkkkxddooolc::::cccc:::;;;;;;::::::cccc:;;,'..;oOK00000KOxl,.......,:oO0KK00000000OOOOOOOOOOOOOOOOkxo\n" +
"okXNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKK00KKKK0000KNWWWNKOxddoollllooddxxkkkxxxxxxkkkxxdddolc::::;;,,,,;;;;;;;;;;;:::::::ccc:;;,...,lk0KK0O00K0kl,.....''''';cloooodddxkO000000OOOOOOOOOOkxo\n" +
"okXNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKK00KKKK00000KNWWWX0kddxxddollllllloooooollllllllcc::;;,,,,,,,,,,,,,,,;;;;:::::cc:::::::,....:x0KK0OO00KKOd;.......''''......',;;:codkO000OOOOOOOOOOOxo\n" +
"okXNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK00000000XWMWX0xolddxddddoolllllllcc::;;;;;;,,,,,,,',,,;;,;;;;;;;;;:::::::cc::;;,,'...,oOKK0OOO0KKX0d:'........''........',,;;;;:coxkO000OOOOOOOxo\n" +
"okXNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK00KKKK0kkKWMWNXOdooooooooddooooolllcc:;;;;;;;;;;;;,,,;;;;;;;;;;;;::::::::::::;,,.. .'lkKXK0OOO0KKKKkc'..................',,,;;;;;,,;coxOO0000OOOxo\n" +
"okXNNXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK0OkxodONMMWWX0kdoooolloooodddoooolllccccc::::::;;;;;:::;;:;;;;:::::::::;;,'.....:xKNXKOkOO0KXKOd:'..................',,,,;;:::;,''';coxkO000Oxo\n" +
"okKNXXXXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK0kxolcclkXWWWWWNKOxooooollloodooooooollccccccc::::;;;;;;;;;;;;;;;::::::;;,'.....:x0XXK0OkkO0KXKkl,...''..............',,,,;,;;;;;,,'''',;codkOOxd\n" +
"okKNXNNNXXXXXXXXXXXXXXXKKKKKKKXKKKKKKKKKKKKKKKKKKKKKK0kdc:;;;:lx0NWWWWWNX0xdoooooooooooooooolllccccc::::;;;;;;;;;;;;;,;;:::;;,''....':x0XNX0OkkOO0KK0xc,...................',;;;;;;;;;;,,'''''''',;:looo\n" +
"oOXNNNNNXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKKKKKKKKKK0Okdoc;,,,;:cld0NWMWWNWNXOxdoddddoooooooollllllcc:::;;;;;;;;;;;;;;;;;;;;;;'.....;lkKNNNK0OkxkO00Oxc;'...................',,;;;;;,;;;,,''',,,,,,,'',;cl\n" +
"dOXNNNNNNXXXXXXXXXXXXKKKKKKKKKKKKKKKKKXXKKKKKKKK0kxdolc:;,'';:c:cxKNWWWNNNNNKOkxdddddddooooollllllcc:::;;;;;;;,,,,,;;;;,,''....'cdxOKNNX0OkkkOOkxdl;'....................',,;;;;;;;;;;,'''',,,,,,,,,,;cl\n" +
"okXNNXXXXXXXXXXXXXXXXXXXXXXKKKKXXKKKKKKKKKXXXK0kddoolc:;,'..';lccld0NWWWNNNWWNK0Oxdddxxxdddooolllllllccc::;;;,,,,;;,,,,'.....;lxkxocd0K0Oxxxkkxoc,'......................',;;;,,,;;;;;,'..',,,,,,,,;;;cl\n" +
"okXNNNXXXXXXXXXXXXXXXXKKKKKKKKKKKKKKKKKKKXXK0Oxdooolc:;,'....,clc:cxXNWWWWWWNNNNXK0kkxxxxxxddooollllllllcc::;;;,,,;,'....';lxO0Oxc,.:xOOOkxddol:,''..''.....'...........',;;;;;;;;;;;;'...',,;;,,,;,,;cl\n" +
"dOXNNWNNNNNNNNNNNNNXXXXXXXXXXXXXXXXXXXXXXK0kxoloooolc;,'.....,:cc::okKNWN0kdoddk0XNNK0kkxxxxxdddooollcccccc:::;;,'''''';okO0Okxo:,..lO0kxdoc:;,,,''..''''.............',;;:;;;;:;;;;;,'....',,,,,;;,,;cl\n" +
"dxO00KK000000000000000000OO0000KKKKK000Okxolcccoolc::;,'.....,::::::ckXXkc'.   .,lkKXNXK0OOOkxddddoolllcccc:::;;;,',:oxOOkxool:,....o00xoc:;,,'',''''''''...........'',;;;;;;::;;;;;;,'....'',,,,,,;;:cl\n" +
"lcccccc:::ccccccccccc:::::ccllloddddoollcc::cloooc:;,,'......,;;:cc;;lkOkdl,.    .':dk0KXXNXK0kxxxdooollllccc::;,;coddolc;,,''.... .:kOdc;;,,'''''''''''...........',,;;;,;;:::;;;;;,'.....',,,,,,,,;:cl\n" +
"l:'''..'''''''''....'..',;:ccccc:::;;;;;::::cloolc:;'.....'.'';;:cc:;:cdOKKkc.      .':oxO00000KK0Okkxxddollc:;,,;cc;..........    .,lol;,,,,,''''',''............',,;;;;;;::::;;;;;,'.....',,,,,,,;;:cl\n" +
"lc:;,,;;;,',;:;;;;;;;;;;:clollcc::;;;;;:::::clooc:;,'....'''',,;;;;:::::coxOkl,.     ..,;::;;:ldxkOkkkdolc:,''...............     .';:::,,',,,,'''','.......'''.'',;;;;;;;::::::;;;;,'.....',,,,,,,;;:cl\n" +
"oxOOOOOOkoloxOOOOOOOkxdolllllcc:::;;;;;:::::clolc:;,'...',,,',,,;;;::::::::cool;.................',,,,''....................   ..';::::;;,,'',,,'''........''''',,;;;;;,;;::cc::;;;;,'.....',,,,,,;;;:cl\n" +
"dONWWWNNXOkkOO0OOOOOkxdolccccc:::::;;;;;;:::clolc:;,'..',;;,,,,,;;;::::::c:::cll:,.... ..................................    ..;:::;;;;;,,,'''''''......''''''',;;;;;,,;;::cc:::;;;;,......',,,;;;;;;:cl\n" +
"dOXNXK0Okxolllcc::::;;::ccllccc:::::;;;;;;:cllllc:;,...',;;;,,,,;;;;;:::::;;;:lllcc:;'..    ............................   .';:cc:;,,,,,',,,,'........',,''''',;;:;;,,,;;::c::::;;;;'.....',,,,,;;;;::cl\n" +
"oxkkxddooolllcc:::;;;:::cccccccccc:::::;;::clllc::;,...',;:;;;,,,;;;;;::::;:::c::clllcc;'..   .......................   ..,:cc:;,;;;;,,,,,,,''.....',;,,'''',,;;;;;,,,,;;::::::::;;,'.....,,,,,,;;;;::lo\n" +
"llooloolllllcc::::::::ccc:::ccccc:::::::;:clllcc::;,...',;::;;;,;;;;:::::;;:::;;:ccccccllc;'......................    .';:ccc:;;,,,;;;;;,,,'.....',,;,,'.'',;;;;;,,,,,,;;::::::::;;,'....',,,,,,;;;;;:lo\n" +
"ooolloollcccc:::;;;;::cccccccccc::;;;;;;;:cllcccc:;,'..',;;;;;;;,,;;::::::::;;;::cc::ccllcccc:;'..   ............  ..,:c:;;;;;;;;;,,,;;,,,'.....,;,,''''',;:::;;;,,,',,;::cc:::::;;,'....',,,,;;;,,;;clo\n" +
"ooollllllccc::;;;;;::::cccccccc:::;;;;;;;:cllccc::;,..',;;:::::;;;;;;;::::::::::::cc:ccc:::clllc:,'................;:lcc:;;;;;;;;;;;,,''''....'',''...'',;:::;;;,,,''',;:ccc:::::;;,'....',,,,;;;;,;:clo\n" +
"llllllllllcc::;,;;;:::ccccccc:::::;;,,,,;:cllcc::;,'...,;;::::::::;;;;;;::::::::c::cccc:::cccc:ccllcc:;,'.......,:::::;::::::;;;,,;;;,'....'',,,'...'',;::;;;;,,;,,,,,,;:cc::::;;;;,'....,;;;;;;;,,;:cll\n" +
"olcclllllcccc:;;;;:::::ccccccc::::;;,,,;;:clcc:::;,'...',;:::::::;;;,,,;::::::::::::cc:::cc::;::clllccc:;,''',;::::::;;;;;;:::;,,,,,,'...'',''....'',;:cc::;,,,;,,,,,,;::ccc:::;;;;,'...',;;;;;,,,,;:clo\n" +
"lcccclllcccccc:;;;;;::::::::::::::;;;;;:cclcc::::;,'..'',;;;;:::;;;;;;;;;;;;::::::::::::ccc:;:ccccc::;;:ccc:::::;;;;:::::;;;;:;;,''.....',''....'',;;::c:::;;;;;,,,,,,;:cccc::::;,,,....',;;;;,,,,,;:clo\n" +
"lc::cclllccccc:;,,,;;;::::::;;;:::;;,,;:ccccc:::;;,'...',;;;::::::::::;;;;;;:::::::::::ccc:::ccc::::::cllc::::::::;;,;::c:;,,,,,'....''''''...',,;;:::::;:::;;;,,,,,,;::ccc::::;;,,'....,;;;;;,,,,;::cll\n" +
"lc::::clllllcc:;;;,;;;;;;;;;;;;:::;;,,;:cccc::::;,'....,;;::::::::::::;;;;;::ccccc::::ccc::ccc::;::cclllc::;:cc:::;;;;,,;;;,,,'...'',,''''''',,;;:::::;;;;;;;;;,,,,,,;:cccc::::;;;,,'.'',;;;;;,,,;;:ccll\n" +
"olc::::cllllcc:::;;;;;;;;;;;;;;;:::;,,;cllcc:::;;,''..',;;;:::::::::::;;;;;;:::ccccccccc::ccc:;;:ccccc:cc:::::::;;;;;;,,',,,,'..'',,,''''',,,,,;;;::::::;;;;;;,,,,,,,;:cccc::::;;;,,''',;:;;;,,,,,;:ccll\n" +
"olc::::cccccccc:;;;;;;;;;;,,,;;;;;;;;;:cllcc:::;;,''''',,;;;::::::::::::;;;;;;;::ccllccc:ccc::::c::::::ccc::;::c:;,,,,,;,,''...',;;,,''',,,,,,,;;;:::::::;;;,,,,,,,,;;:ccc:::::;;,,,,,,;::;;,,''',;:cclo\n" +
"llc:;;::cccllcc::;;;;;;;,,,,;;;;;;;;;:ccccc:::;;,,'''',,,,;;:::::::::::::::;;;;::ccccccccc::cccc:;;;::ccc::;:::c:;;,'',,'''..',,,;,,,,,',,,,,,;;;::::::;;;;;,,,,,,,;;:::cc:::::;;,,,,;;:::;,'''',,;:cllo\n" +
"olc:::ccccllllccccc:::::::::cccc:::::cllllccccc:;;;,;;;::::::ccccccccccc::ccccccccccccllcccccclcc::ccllcc::cccccc::::;;;,,,;::::::::;;;;;;;::::::cccccc:::::::;;;;::::ccccccccc::::::::cc::;;,,;;:cllllo\n" +
"ollllooolllooooooollllllllooooooolllllooooooooooollcclllllllllooooooollllllloooooollloooollllooolllooooolllllolllllllollllllloollolllllllllllooollloollllllllllllllllloooolloooolllllllloolllcllllooooll");
                        			System.out.println("***************************************************************************");
									System.out.println("||Que quieres hacer?:                                                    ||");
									System.out.println("***************************************************************************");
                                                 
                                    if(visit5>=2){
                                        System.out.println("||Sanhueza: Usted quiere volver a reprobar parece                        ||"); 
                                    }
                                    op=6;
									break;

							case 6: System.out.println("***************************************************************************");
									System.out.println("||                          SE GUARDO EL MAPA                            ||");
									System.out.println("***************************************************************************");
									break;
				}
			}while(op!=6);
		}catch(IOException e){
			System.out.println("||                                                                       ||");
			System.out.println("||Error de lectura desde el teclado...                                   ||");
			System.out.println("||                                                                       ||");              
		}
                
	}
    
    public void LlaveFinal(int opcion){
        
        if (opcion==5){
            this.maradona=true;
        }
        else{
            this.maradona=false;
        }    
    }	
}
