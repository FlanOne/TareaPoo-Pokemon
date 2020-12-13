import java.math.*;
public class Pokemon{
    private int level;
    private int acumulador;
	private int id;
	private String nombre;
	private String tipo;
	private boolean capturado;
	private boolean visto;
	private int ps_max;
	private int ps;
    private int defensaOriginal;
	private int poder;
	private int defensa;
	private int velocidad;
	private Ataque [] ataques = new Ataque[SetupPokemon.cantidadAtaques];

	Pokemon(int level,int id, String nombre, String tipo, int ps_max, int poder, int defensaOriginal, int velocidad, String [] listaAtaques){
		int valor=6;
        this.level=level;
        this.acumulador=0;
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.ps_max = ps_max;
		this.ps = this.ps_max;
		this.poder = poder;
        this.defensaOriginal=defensaOriginal;
		this.defensa = defensaOriginal;
		this.velocidad = velocidad;
		this.capturado = false;
		this.visto = false;
		for(int i=0;i<SetupPokemon.cantidadAtaques;i=i+3){
			this.ataques[i] = new Ataque(listaAtaques[i],75,valor-(i+1),valor/2-i);
		}
		for(int i=1;i<SetupPokemon.cantidadAtaques;i=i+2){
			this.ataques[i] = new Ataque(listaAtaques[i],35,valor-(i+1),valor/2-i);
		}
		for(int i=2;i<SetupPokemon.cantidadAtaques;i=i+1){
			this.ataques[i] = new Ataque(listaAtaques[i],i+1,valor-(i+1),valor*i);
		}
	}

    public int getLevel(){
            return this.level; 
        }
    public int getAcumulador(){
            return this.acumulador;
        }
	public void setCapturado(){
		this.capturado = true;
	}
	public void setVisto(){
		this.visto = true;
	}
	public String getNombre(){
		return this.nombre;
	}
	public String getTipo(){
		return this.tipo;
	}
	public boolean getCapturado(){
		return this.capturado;
	}
	public int getId(){
		return this.id;
	}
    public void setPs(int posion){
        this.ps_max=this.ps_max+posion;    
    }

    public void recibirAtaque(Ataque ataque, Pokemon Atacante){
        int A= Atacante.getPoder();
        int N=Atacante.getLevel();
        int P= ataque.getDano();
        int D=this.defensa;
        double E=Efectividad(Atacante);
        double B=1;
        double resultado=0;
        int V=(int)(Math.random()*(100-85)+85);
            
        if(ataque==Atacante.getAtaques()[0]){
            B=1.5;
            resultado=(Math.round(((((0.2*N+1)*A*P)/(25*D)+2)*(V*E*B*0.01)))) ;
            this.ps -= (int)resultado;
        }           
        
        if(ataque==Atacante.getAtaques()[1]){
            resultado=(Math.round(((((0.2*N+1)*A*P)/(25*D)+2)*(V*E*B*0.01)))) ;
            this.ps -= (int)resultado;
        }       
	}

    public void AumentarStats (Ataque ataque){
        int a= ataque.getBloqueo();
        this.defensa=this.defensa + a;
    }

    public void retornarStats(){
        this.defensa=this.defensaOriginal;
    }

    public void ganarEXP(boolean resultado){
        if (resultado){
            this.acumulador=this.acumulador+25;
        }
        else{
            this.acumulador=this.acumulador+15;
        } 
    }

    public boolean NextLevel(){
        int a=100;

        if(this.acumulador >=100){
            this.level= this.level+1;
            this.acumulador=0;
            return true;
        }
        return false;
    }

    public Boolean Evolucion() {
        if(this.nombre=="Bulbasaur"){
            if(this.level==16){
                this.id = 2;
                this.nombre = SetupPokemon.nombres[1];
                this.ps_max =SetupPokemon.ps_max[1] ;
                this.ps = this.ps_max;
                this.poder =SetupPokemon.poder[1] ;
                this.defensaOriginal=SetupPokemon.defensa[1];
                this.defensa = defensaOriginal;
                this.velocidad =SetupPokemon.velocidad[1];
                return true;
            }

        if(this.nombre=="Ivysaur"){
                if(this.level==32){
                    this.id = 3;
                    this.nombre = SetupPokemon.nombres[2];
                    this.ps_max =SetupPokemon.ps_max[2];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[2];
                    this.defensaOriginal=SetupPokemon.defensa[2];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[2];
                    return true;
                }
            }

            if(this.nombre=="Charmander"){
                if(this.level==16){
                    this.id = 5;
                    this.nombre = SetupPokemon.nombres[4];
                    this.ps_max =SetupPokemon.ps_max[4];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[4];
                    this.defensaOriginal=SetupPokemon.defensa[4];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[4];
                    return true;
                }
            }

            if(this.nombre=="Charmeleon"){
                if(this.level==36){
                    this.id = 6;
                    this.nombre = SetupPokemon.nombres[5];
                    this.ps_max =SetupPokemon.ps_max[5];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[5];
                    this.defensaOriginal=SetupPokemon.defensa[5];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[5];
                    return true;
                }
            }

            if(this.nombre=="Squirtle"){
                if(this.level==16){
                    this.id = 8;
                    this.nombre = SetupPokemon.nombres[7];
                    this.ps_max =SetupPokemon.ps_max[7];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[7];
                    this.defensaOriginal=SetupPokemon.defensa[7];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[7];
                    return true;
                }
            }

            if(this.nombre=="Wartortle"){
                if(this.level==36){
                    this.id = 9;
                    this.nombre = SetupPokemon.nombres[8];
                    this.ps_max =SetupPokemon.ps_max[8];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[8];
                    this.defensaOriginal=SetupPokemon.defensa[8];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[8];
                    return true;
                }
            }

            if(this.nombre=="Caterpie"){
                if(this.level==7){
                    this.id = 11;
                    this.nombre = SetupPokemon.nombres[10];
                    this.ps_max =SetupPokemon.ps_max[10];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[10];
                    this.defensaOriginal=SetupPokemon.defensa[10];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[10];
                    return true;
                }
            }

            if(this.nombre=="Metapod"){
                if(this.level==10){
                    this.id = 12;
                    this.nombre = SetupPokemon.nombres[11];
                    this.ps_max =SetupPokemon.ps_max[11];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[11];
                    this.defensaOriginal=SetupPokemon.defensa[11];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[11];
                    return true;
                }
            }

            if(this.nombre=="Weedle"){
                if(this.level==7){
                    this.id = 14;
                    this.nombre = SetupPokemon.nombres[13];
                    this.ps_max =SetupPokemon.ps_max[13];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[13];
                    this.defensaOriginal=SetupPokemon.defensa[13];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[13];
                    return true;
                }
            }

            if(this.nombre=="Kakuna"){
                if(this.level==10){
                    this.id = 15;
                    this.nombre = SetupPokemon.nombres[14];
                    this.ps_max =SetupPokemon.ps_max[14];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[14];
                    this.defensaOriginal=SetupPokemon.defensa[14];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[14];
                    return true;
                }
            }

            if(this.nombre=="Pidgey"){
                if(this.level==18){
                    this.id = 17;
                    this.nombre = SetupPokemon.nombres[16];
                    this.ps_max =SetupPokemon.ps_max[16];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[16];
                    this.defensaOriginal=SetupPokemon.defensa[16];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[16];
                    return true;
                }
            }

            if(this.nombre=="Pidgeotto"){
                if(this.level==36){
                    this.id = 18;
                    this.nombre = SetupPokemon.nombres[17];
                    this.ps_max =SetupPokemon.ps_max[17];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[17];
                    this.defensaOriginal=SetupPokemon.defensa[17];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[17];
                    return true;
                }
            }

            if(this.nombre=="Rattata"){
                if(this.level==20){
                    this.id = 20;
                    this.nombre = SetupPokemon.nombres[19];
                    this.ps_max =SetupPokemon.ps_max[19];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[19];
                    this.defensaOriginal=SetupPokemon.defensa[19];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[19];
                    return true;
                }
            }

            if(this.nombre=="Spearow"){
                if(this.level==20){
                    this.id = 22;
                    this.nombre = SetupPokemon.nombres[21];
                    this.ps_max =SetupPokemon.ps_max[21];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[21];
                    this.defensaOriginal=SetupPokemon.defensa[21];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[21];
                    return true;
                }
            }

            if(this.nombre=="Ekans"){
                if(this.level==22){
                    this.id = 24;
                    this.nombre = SetupPokemon.nombres[23];
                    this.ps_max =SetupPokemon.ps_max[23];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[23];
                    this.defensaOriginal=SetupPokemon.defensa[23];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[23];
                    return true;
                }
            }

            if(this.nombre=="Pikachu"){
                if(this.level==36){
                    this.id = 26;
                    this.nombre = SetupPokemon.nombres[25];
                    this.ps_max =SetupPokemon.ps_max[25];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[25];
                    this.defensaOriginal=SetupPokemon.defensa[25];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[25];
                    return true;
                }
            }

            if(this.nombre=="Sandshrew"){
                if(this.level==22){
                    this.id = 28;
                    this.nombre = SetupPokemon.nombres[27];
                    this.ps_max =SetupPokemon.ps_max[27];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[27];
                    this.defensaOriginal=SetupPokemon.defensa[27];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[27];
                    return true;
                }
            }

            if(this.nombre=="Nidoran♀"){
                if(this.level==16){
                    this.id = 30;
                    this.nombre = SetupPokemon.nombres[29];
                    this.ps_max =SetupPokemon.ps_max[29];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[29];
                    this.defensaOriginal=SetupPokemon.defensa[29];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[29];
                    return true;
                }
            }

            if(this.nombre=="Nidorina"){
                if(this.level==36){
                    this.id = 31;
                    this.nombre = SetupPokemon.nombres[30];
                    this.ps_max =SetupPokemon.ps_max[30];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[30];
                    this.defensaOriginal=SetupPokemon.defensa[30];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[30];
                    return true;
                }
            }

            if(this.nombre=="Nidoran♂"){
                if(this.level==16){
                    this.id = 33;
                    this.nombre = SetupPokemon.nombres[32];
                    this.ps_max =SetupPokemon.ps_max[32];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[32];
                    this.defensaOriginal=SetupPokemon.defensa[32];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[32];
                    return true;
                }
            }

            if(this.nombre=="Nidorino"){
                if(this.level==36){
                    this.id = 34;
                    this.nombre = SetupPokemon.nombres[33];
                    this.ps_max =SetupPokemon.ps_max[33];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[33];
                    this.defensaOriginal=SetupPokemon.defensa[33];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[33];
                    return true;
                }
            }

            if(this.nombre=="Clefairy"){
                if(this.level==36){
                    this.id = 36;
                    this.nombre = SetupPokemon.nombres[35];
                    this.ps_max =SetupPokemon.ps_max[35];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[35] ;
                    this.defensaOriginal=SetupPokemon.defensa[35];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[35];
                    return true;
                }
            }

            if(this.nombre=="Vulpix"){
                if(this.level==20){
                    this.id = 38;
                    this.nombre = SetupPokemon.nombres[37];
                    this.ps_max =SetupPokemon.ps_max[37];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[37];
                    this.defensaOriginal=SetupPokemon.defensa[37];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[37];
                    return true;
                }
            }

            if(this.nombre=="Jigglypuff"){
                if(this.level==20){
                    this.id = 40;
                    this.nombre = SetupPokemon.nombres[39];
                    this.ps_max =SetupPokemon.ps_max[39];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[39];
                    this.defensaOriginal=SetupPokemon.defensa[39];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[39];
                    return true;
                }
            }

            if(this.nombre=="Zubat"){
                if(this.level==22){
                    this.id = 42;
                    this.nombre = SetupPokemon.nombres[41];
                    this.ps_max =SetupPokemon.ps_max[41];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[41];
                    this.defensaOriginal=SetupPokemon.defensa[41];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[41];
                    return true;
                }
            }

            if(this.nombre=="Oddish"){
                if(this.level==21){
                    this.id = 44;
                    this.nombre = SetupPokemon.nombres[43];
                    this.ps_max =SetupPokemon.ps_max[43];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[43];
                    this.defensaOriginal=SetupPokemon.defensa[43];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[43];
                    return true;
                }
            }

            if(this.nombre=="Gloom"){
                if(this.level==30){
                    this.id = 45;
                    this.nombre = SetupPokemon.nombres[44];
                    this.ps_max =SetupPokemon.ps_max[44];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[44];
                    this.defensaOriginal=SetupPokemon.defensa[44];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[44];
                    return true;
                }
            }

            if(this.nombre=="Paras"){
                if(this.level==24){
                    this.id = 47;
                    this.nombre = SetupPokemon.nombres[46];
                    this.ps_max =SetupPokemon.ps_max[46];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[46];
                    this.defensaOriginal=SetupPokemon.defensa[46];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[46];
                    return true;
                }
            }

            if(this.nombre=="Venonat"){
                if(this.level==31){
                    this.id = 49;
                    this.nombre = SetupPokemon.nombres[48];
                    this.ps_max =SetupPokemon.ps_max[48];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[48];
                    this.defensaOriginal=SetupPokemon.defensa[48];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[48];
                    return true;
                }
            }

            if(this.nombre=="Diglett"){
                if(this.level==26){
                    this.id = 51;
                    this.nombre = SetupPokemon.nombres[50];
                    this.ps_max =SetupPokemon.ps_max[50];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[50];
                    this.defensaOriginal=SetupPokemon.defensa[50];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[50];
                    return true;
                }
            }

            if(this.nombre=="Meowth"){
                if(this.level==28){
                    this.id = 53;
                    this.nombre = SetupPokemon.nombres[52];
                    this.ps_max =SetupPokemon.ps_max[52];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[52];
                    this.defensaOriginal=SetupPokemon.defensa[52];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[52];
                    return true;
                }
            }

            if(this.nombre=="Psyduck"){
                if(this.level==33){
                    this.id = 55;
                    this.nombre = SetupPokemon.nombres[54];
                    this.ps_max =SetupPokemon.ps_max[54];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[54];
                    this.defensaOriginal=SetupPokemon.defensa[54];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[54];
                    return true;
                }
            }

            if(this.nombre=="Mankey"){
                if(this.level==28){
                    this.id = 57;
                    this.nombre = SetupPokemon.nombres[56];
                    this.ps_max =SetupPokemon.ps_max[56];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[56];
                    this.defensaOriginal=SetupPokemon.defensa[56];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[56];
                    return true;
                }
            }

            if(this.nombre=="Growlithe"){
                if(this.level==33){
                    this.id = 59;
                    this.nombre = SetupPokemon.nombres[58];
                    this.ps_max =SetupPokemon.ps_max[58];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[58];
                    this.defensaOriginal=SetupPokemon.defensa[58];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[58];
                    return true;
                }
            }

            if(this.nombre=="Poliwag"){
                if(this.level==25){
                    this.id = 61;
                    this.nombre = SetupPokemon.nombres[60];
                    this.ps_max =SetupPokemon.ps_max[60];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[60];
                    this.defensaOriginal=SetupPokemon.defensa[60];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[60];
                    return true;
                }
            }

            if(this.nombre=="Poliwhirl"){
                if(this.level==35){
                    this.id = 62;
                    this.nombre = SetupPokemon.nombres[61];
                    this.ps_max =SetupPokemon.ps_max[61];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[61];
                    this.defensaOriginal=SetupPokemon.defensa[61];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[61];
                    return true;
                }
            }

            if(this.nombre=="Abra"){
                if(this.level==16){
                    this.id = 64;
                    this.nombre = SetupPokemon.nombres[63];
                    this.ps_max =SetupPokemon.ps_max[63];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[63];
                    this.defensaOriginal=SetupPokemon.defensa[63];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[63];
                    return true;
                }
            }

            if(this.nombre=="Kadabra"){
                if(this.level==36){
                    this.id = 65;
                    this.nombre = SetupPokemon.nombres[64];
                    this.ps_max =SetupPokemon.ps_max[64];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[64];
                    this.defensaOriginal=SetupPokemon.defensa[64];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[64];
                    return true;
                }
            }

            if(this.nombre=="Machop"){
                if(this.level==28){
                    this.id = 67;
                    this.nombre = SetupPokemon.nombres[66];
                    this.ps_max =SetupPokemon.ps_max[66];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[66];
                    this.defensaOriginal=SetupPokemon.defensa[66];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[66];
                    return true;
                }
            }

            if(this.nombre=="Machoke"){
                if(this.level==38){
                    this.id = 68;
                    this.nombre = SetupPokemon.nombres[67];
                    this.ps_max =SetupPokemon.ps_max[67];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[67];
                    this.defensaOriginal=SetupPokemon.defensa[67];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[67];
                    return true;
                }
            }

            if(this.nombre=="Bellsprout"){
                if(this.level==21){
                    this.id = 70;
                    this.nombre = SetupPokemon.nombres[69];
                    this.ps_max =SetupPokemon.ps_max[69];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[69];
                    this.defensaOriginal=SetupPokemon.defensa[69];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[69];
                    return true;
                }
            }

            if(this.nombre=="Weepinbell"){
                if(this.level==36){
                    this.id = 71;
                    this.nombre = SetupPokemon.nombres[70];
                    this.ps_max =SetupPokemon.ps_max[70];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[70];
                    this.defensaOriginal=SetupPokemon.defensa[70];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[70];
                    return true;
                }
            }

            if(this.nombre=="Tentacool"){
                if(this.level==30){
                    this.id = 73;
                    this.nombre = SetupPokemon.nombres[72];
                    this.ps_max =SetupPokemon.ps_max[72];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[72];
                    this.defensaOriginal=SetupPokemon.defensa[72];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[72];
                    return true;
                }
            }

            if(this.nombre=="Geodude"){
                if(this.level==25){
                    this.id = 75;
                    this.nombre = SetupPokemon.nombres[74];
                    this.ps_max =SetupPokemon.ps_max[74];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[74];
                    this.defensaOriginal=SetupPokemon.defensa[74];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[74];
                    return true;
                }
            }

            if(this.nombre=="Graveler"){
                if(this.level==35){
                    this.id = 76;
                    this.nombre = SetupPokemon.nombres[75];
                    this.ps_max =SetupPokemon.ps_max[75];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[75];
                    this.defensaOriginal=SetupPokemon.defensa[75];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[75];
                    return true;
                }
            }

            if(this.nombre=="Ponyta"){
                if(this.level==40){
                    this.id = 78;
                    this.nombre = SetupPokemon.nombres[77];
                    this.ps_max =SetupPokemon.ps_max[77];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[77];
                    this.defensaOriginal=SetupPokemon.defensa[77];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[77];
                    return true;
                }
            }

            if(this.nombre=="Slowpoke"){
                if(this.level==37){
                    this.id = 80;
                    this.nombre = SetupPokemon.nombres[79];
                    this.ps_max =SetupPokemon.ps_max[79];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[79];
                    this.defensaOriginal=SetupPokemon.defensa[79];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[79];
                    return true;
                }
            }

            if(this.nombre=="Magnemite"){
                if(this.level==30){
                    this.id = 82;
                    this.nombre = SetupPokemon.nombres[81];
                    this.ps_max =SetupPokemon.ps_max[81];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[81];
                    this.defensaOriginal=SetupPokemon.defensa[81];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[81];
                    return true;
                }
            }

            if(this.nombre=="Doduo"){
                if(this.level==31){
                    this.id = 85;
                    this.nombre = SetupPokemon.nombres[84];
                    this.ps_max =SetupPokemon.ps_max[84];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[84];
                    this.defensaOriginal=SetupPokemon.defensa[84];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[84];
                    return true;
                }
            }

            if(this.nombre=="Seel"){
                if(this.level==34){
                    this.id = 87;
                    this.nombre = SetupPokemon.nombres[86];
                    this.ps_max =SetupPokemon.ps_max[86];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[86];
                    this.defensaOriginal=SetupPokemon.defensa[86];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[86];
                    return true;
                }
            }

            if(this.nombre=="Grimer"){
                if(this.level==38){
                    this.id = 89;
                    this.nombre = SetupPokemon.nombres[88];
                    this.ps_max =SetupPokemon.ps_max[88];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[88];
                    this.defensaOriginal=SetupPokemon.defensa[88];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[88];
                    return true;
                }
            }

            if(this.nombre=="Shellder"){
                if(this.level==30){
                    this.id = 91;
                    this.nombre = SetupPokemon.nombres[90];
                    this.ps_max =SetupPokemon.ps_max[90];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[90];
                    this.defensaOriginal=SetupPokemon.defensa[90];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[90];
                    return true;
                }
            }

            if(this.nombre=="Gastly"){
                if(this.level==25){
                    this.id = 93;
                    this.nombre = SetupPokemon.nombres[92];
                    this.ps_max =SetupPokemon.ps_max[92];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[92];
                    this.defensaOriginal=SetupPokemon.defensa[92];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[92];
                    return true;
                }
            }

            if(this.nombre=="Haunter"){
                if(this.level==35){
                    this.id = 94;
                    this.nombre = SetupPokemon.nombres[93];
                    this.ps_max =SetupPokemon.ps_max[93];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[93];
                    this.defensaOriginal=SetupPokemon.defensa[93];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[93];
                    return true;
                }
            }

            if(this.nombre=="Drowzee"){
                if(this.level==26){
                    this.id = 97;
                    this.nombre = SetupPokemon.nombres[96];
                    this.ps_max =SetupPokemon.ps_max[96];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[96];
                    this.defensaOriginal=SetupPokemon.defensa[96];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[96];
                    return true;
                }
            }

            if(this.nombre=="Krabby"){
                if(this.level==28){
                    this.id = 99;
                    this.nombre = SetupPokemon.nombres[98];
                    this.ps_max =SetupPokemon.ps_max[98];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[98];
                    this.defensaOriginal=SetupPokemon.defensa[98];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[98];
                    return true;
                }
            }

            if(this.nombre=="Voltorb"){
                if(this.level==30){
                    this.id = 101;
                    this.nombre = SetupPokemon.nombres[100];
                    this.ps_max =SetupPokemon.ps_max[100];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[100];
                    this.defensaOriginal=SetupPokemon.defensa[100];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[100];
                    return true;
                }
            }

            if(this.nombre=="Exeggcute"){
                if(this.level==30){
                    this.id = 103;
                    this.nombre = SetupPokemon.nombres[102];
                    this.ps_max =SetupPokemon.ps_max[102];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[102];
                    this.defensaOriginal=SetupPokemon.defensa[102];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[102];
                    return true;
                }
            }

            if(this.nombre=="Cubone"){
                if(this.level==28){
                    this.id = 105;
                    this.nombre = SetupPokemon.nombres[104];
                    this.ps_max =SetupPokemon.ps_max[104];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[104];
                    this.defensaOriginal=SetupPokemon.defensa[104];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[104];
                    return true;
                }
            }

            if(this.nombre=="Koffing"){
                if(this.level==35){
                    this.id = 110;
                    this.nombre = SetupPokemon.nombres[109];
                    this.ps_max =SetupPokemon.ps_max[109];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[109];
                    this.defensaOriginal=SetupPokemon.defensa[109];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[109];
                    return true;
                }
            }

            if(this.nombre=="Rhyhorn"){
                if(this.level==42){
                    this.id = 112;
                    this.nombre = SetupPokemon.nombres[111];
                    this.ps_max =SetupPokemon.ps_max[111];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[111];
                    this.defensaOriginal=SetupPokemon.defensa[111];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[111];
                    return true;
                }
            }

            if(this.nombre=="Horsea"){
                if(this.level==32){
                    this.id = 117;
                    this.nombre = SetupPokemon.nombres[116];
                    this.ps_max =SetupPokemon.ps_max[116];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[116];
                    this.defensaOriginal=SetupPokemon.defensa[116];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[116];
                    return true;
                }
            }

            if(this.nombre=="Goldeen"){
                if(this.level==33){
                    this.id = 119;
                    this.nombre = SetupPokemon.nombres[118];
                    this.ps_max =SetupPokemon.ps_max[118];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[118];
                    this.defensaOriginal=SetupPokemon.defensa[118];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[118];
                    return true;
                }
            }

            if(this.nombre=="Staryu"){
                if(this.level==33){
                    this.id = 121;
                    this.nombre = SetupPokemon.nombres[120];
                    this.ps_max =SetupPokemon.ps_max[120];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[120];
                    this.defensaOriginal=SetupPokemon.defensa[120];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[120];
                    return true;
                }
            }

            if(this.nombre=="Magikarp"){
                if(this.level==20){
                    this.id = 130;
                    this.nombre = SetupPokemon.nombres[129];
                    this.ps_max =SetupPokemon.ps_max[129];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[129];
                    this.defensaOriginal=SetupPokemon.defensa[129];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[129];
                    return true;
                }
            }

            if(this.nombre=="Eevee"){
                if(this.level==20 && this.ps_max==150){ //VAPORION
                    this.id = 134;
                    this.nombre = SetupPokemon.nombres[133];
                    this.ps_max =SetupPokemon.ps_max[133];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[133];
                    this.defensaOriginal=SetupPokemon.defensa[133];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[133];
                    return true;
                }
                else if(this.level==20 && this.ps_max==180){ //JOLTEON
                    this.id = 135;
                    this.nombre = SetupPokemon.nombres[134];
                    this.ps_max =SetupPokemon.ps_max[134];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[134];
                    this.defensaOriginal=SetupPokemon.defensa[134];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[134];
                    return true;
                }
                else if(this.level==20 && this.ps_max==200){ //FLAREON
                    this.id = 136;
                    this.nombre = SetupPokemon.nombres[135];
                    this.ps_max =SetupPokemon.ps_max[135];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[135];
                    this.defensaOriginal=SetupPokemon.defensa[135];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[135];
                    return true;
                }
            }

            if(this.nombre=="Omanyte"){
                if(this.level==40){
                    this.id = 139;
                    this.nombre = SetupPokemon.nombres[138];
                    this.ps_max =SetupPokemon.ps_max[138];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[138];
                    this.defensaOriginal=SetupPokemon.defensa[138];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[138];
                    return true;
                }
            }

            if(this.nombre=="Kabuto"){
                if(this.level==40){
                    this.id = 141;
                    this.nombre = SetupPokemon.nombres[140];
                    this.ps_max =SetupPokemon.ps_max[140];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[140];
                    this.defensaOriginal=SetupPokemon.defensa[140];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[140];
                    return true;
                }
            }

            if(this.nombre=="Dratini"){
                if(this.level==30){
                    this.id = 148;
                    this.nombre = SetupPokemon.nombres[147];
                    this.ps_max =SetupPokemon.ps_max[147];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[147];
                    this.defensaOriginal=SetupPokemon.defensa[147];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[147];
                    return true;
                }
            }

            if(this.nombre=="Dragonair"){
                if(this.level==55){
                    this.id = 149;
                    this.nombre = SetupPokemon.nombres[148];
                    this.ps_max =SetupPokemon.ps_max[148];
                    this.ps = this.ps_max;
                    this.poder =SetupPokemon.poder[148];
                    this.defensaOriginal=SetupPokemon.defensa[148];
                    this.defensa = defensaOriginal;
                    this.velocidad =SetupPokemon.velocidad[148];
                    return true;
                }
            }
            return false;    
        }
        return false;
    }

    public double Efectividad(Pokemon Atacante){
        double E=1;
        //"agua","bicho","dragon","electrico","fantasma","fuego","hielo","lucha","normal","planta","psiquico","roca","tierra","veneno","volador"            

        if(Atacante.getTipo()=="agua"){
	        if(this.tipo=="agua" || this.tipo=="dragon" || this.tipo=="planta"){
	            E=(0.5);
	        }
	        else if(this.tipo=="fuego" || this.tipo=="roca" || this.tipo=="tierra"){
	           	E=2;
	        }
	    }

            if(Atacante.getTipo()=="bicho"){
                if(this.tipo=="fantasma" || this.tipo=="fuego" || this.tipo=="lucha" || this.tipo=="veneno" || this.tipo=="volador"){
                    E=(0.5);
                }
                else if(this.tipo=="planta" || this.tipo=="psiquico"){
                    E=2;
                }
            }

            if(Atacante.getTipo()=="dragon"){
                if(this.tipo=="dragon"){
                    E=2;            
                }  
            }

            if(Atacante.getTipo()=="electrico"){
                if(this.tipo=="agua" || this.tipo=="volador"){
                    E=2;
                }
                else if(this.tipo=="dragon" || this.tipo=="electrico" || this.tipo=="planta"){
                    E=(0.5);
                }
                else if(this.tipo=="tierra"){
                    E=0;
                }
            }

            if(Atacante.getTipo()=="fantasma"){
                if(this.tipo=="fantasma" || this.tipo=="psiquico"){
                    E=2;
                }
                else if(this.tipo=="normal"){
                    E=0;
                }
            }

            if(Atacante.getTipo()=="fuego"){
                if(this.tipo=="agua" || this.tipo=="dragon" || this.tipo=="fuego" || this.tipo=="roca"){
                    E=(0.5);
                }
                else if(this.tipo=="bicho" || this.tipo=="hielo" || this.tipo=="planta"){
                    E=2;
                }
            }

            if(Atacante.getTipo()=="hielo"){
                if(this.tipo=="agua" || this.tipo=="fuego" || this.tipo=="hielo"){
                    E=(0.5);
                }
                else if(this.tipo=="dragon" || this.tipo=="planta" || this.tipo=="tierra" || this.tipo=="volador"){
                    E=2;    
                }
            }

            if(Atacante.getTipo()=="lucha"){
                if(this.tipo=="bicho" || this.tipo=="psiquico" || this.tipo=="veneno" || this.tipo=="volador"){
                    E=(0.5);
                }
                else if(this.tipo=="hielo" || this.tipo=="normal" || this.tipo=="roca"){
                    E=2;
                }
                else if(this.tipo=="fantasma"){
                    E=0;
                }
            }

            if(Atacante.getTipo()=="normal"){
            	if(this.tipo=="fantasma"){
            		E=0;
            	}
            	else if(this.tipo=="roca"){
            		E=(0.5);
            	}
            }

            if(Atacante.getTipo()=="planta"){
                if(this.tipo=="agua" || this.tipo=="roca" || this.tipo=="tierra"){
                    E=2;
                }
                else if(this.tipo=="bicho" || this.tipo=="dragon" || this.tipo=="fuego" || this.tipo=="planta" || this.tipo=="veneno" || this.tipo=="volador"){
                    E=(0.5);    
                }
            }

            if(Atacante.getTipo()=="psiquico"){
            	if(this.tipo=="lucha" || this.tipo=="veneno"){
            		E=2;
            	}
            	else if(this.tipo=="psiquico"){
            		E=(0.5);	
            	}
            }

            if(Atacante.getTipo()=="roca"){
            	if(this.tipo=="bicho" || this.tipo=="fuego" || this.tipo=="hielo" || this.tipo=="volador"){
            		E=2;
            	}
            	else if(this.tipo=="lucha" || this.tipo=="tierra"){
            		E=(0.5);
            	}
            }

            if(Atacante.getTipo()=="tierra"){
            	if(this.tipo=="bicho" || this.tipo=="planta"){
            		E=(0.5);
            	}
            	else if(this.tipo=="electricidad" || this.tipo=="fuego" || this.tipo=="roca" || this.tipo=="veneno"){
            		E=2;	
            	}
            	else if(this.tipo=="volador"){
            		E=0;
            	}
            }

            if(Atacante.getTipo()=="veneno"){
            	if(this.tipo=="fantasma" || this.tipo=="roca" || this.tipo=="tierra" || this.tipo=="veneno"){
            		E=(0.5);
            	}
            	else if(this.tipo=="planta"){
            		E=2;	
            	}
            }

            if(Atacante.getTipo()=="volador"){
            	if(this.tipo=="bicho" || this.tipo=="lucha" || this.tipo=="planta"){
            		E=2;
            	}
            	if(this.tipo=="electrico" || this.tipo=="roca"){
            		E=(0.5);	
            	}
            }
            return E;
        }

	public Ataque [] getAtaques(){
		return ataques;
	}

	public int getPs(){
		return ps;
	}

	public int getPoder(){
		return poder;
	}

	public int getDefensa(){
		return defensa;
	}

	public int getVelocidad(){
		return velocidad;
	}

    public int getPs_max(){
        return ps_max;
    }
    
	public void restaurar(){
		this.ps = this.ps_max;
	}
}