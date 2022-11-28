import java.text.DecimalFormat;
import java.util.Arrays;

public class App
{
    public static CadastroDinossauro cadastro = new CadastroDinossauro();

    public static int[][] zoo = new int[150][150];

    public static String[] nomeRaca = new String[cadastro.tamanho];
    
    public static char[] vowel = {'a', 'i', 'u', 'e', 'o'};

    public static String dinoRatio()
    {
        int prox = cadastro.proximaPosicao;
        
        String ratio = Integer.toString(prox);

        ratio += "/" + String.valueOf(cadastro.tamanho) + " Dinossauros cadastrados";

        return(ratio);
    }
    
    public static int lengthCadDinos()
    {
        return cadastro.tamanho;
    }

    public static int quant_dinos()
    {
        return cadastro.proximaPosicao;        
    }
    
    public static String dinoString(int i)
    {
        String str = "ID: " + String.valueOf(cadastro.cadastroDinossauros[i].getIdDinossauro());
        
        str += ", Race: " + cadastro.cadastroDinossauros[i].getNomeRaca();
        
        str += ", Type: " + String.valueOf(cadastro.cadastroDinossauros[i].getTipo());

        str += ", Category: " + String.valueOf(cadastro.cadastroDinossauros[i].getCategoria());
        
        str += ", Weight: " + String.valueOf(cadastro.cadastroDinossauros[i].getPeso());
        
        return str;
    }

    public static void add(String a, String race, String b, String c, String d, String e, String f)
    {
        int id = Integer.parseInt(a);

        int type = Integer.parseInt(b);

        int category = Integer.parseInt(c);

        double weight = Double.parseDouble(d);

        int posX = Integer.parseInt(e) - 1;

        int posY = Integer.parseInt(f) - 1;

        int err_count = 0;

        if(cadastro.contemDinossauro(id))
        {
            TF.loadErrorID();

            err_count++;
        }

        if(race.equals(""))
        {
            TF.loadErrorRACE();

            err_count++;
        }
        
        if(weight == 0)
        {
            TF.loadErrorWEIGHT();

            err_count++;
        }
        
        if(err_count == 0)
        {
            if(zoo[posX][posY] == 0)
            {
                zoo[posX][posY] = id;
                
                cadastro.adicionarDinossauro(new Dinossauro(id, race, type, category, weight));

                nomeRaca[id - 1] = race;

                TF.loadAddedMessage();
            }
            else
            {
                TF.loadErrorPOS();
            }
        }
    }

    public static void rem(String str)
    {
        int id = Integer.parseInt(str);

        cadastro.removerDinossauro(id);

        nomeRaca[id - 1] = null;

        for(int i = 0; i < zoo.length; i++)
        {
            for(int j = 0; j < zoo.length; j++)
            {
                if(zoo[i][j] == id)
                {
                    zoo[i][j] = 0;
                }
            }
        }
        
        TF.loadRemMessage();
    }

    public static String typeCategory(int type)
    {
        String str = "";

        if(type == 1)
        {
            str += "Carnivores: ";
        }
        else
        {
            str += "Herbivores: ";
        }

        int pp = 0, mp = 0, gp = 0;

        for(int i = 0; i < cadastro.proximaPosicao; i++)
        {
            if(cadastro.cadastroDinossauros[i].getTipo() == type)
            {
                if(cadastro.cadastroDinossauros[i].getCategoria() != 1)
                {
                    if(cadastro.cadastroDinossauros[i].getCategoria() != 2)
                    {
                        gp++;
                    }
                    else
                    {
                        mp++;
                    }
                }
                else
                {
                    pp++;
                }
            }
        }

        str += "PP: " + String.valueOf(pp) + ", MP: " + String.valueOf(mp);

        str += ", GP: " + String.valueOf(gp);

        return str;
    }

    public static String report2(String type, String category, int i)
    {
        Dinossauro[] dino = heavyWeight(type, category);

        String str = "ID: " + String.valueOf(dino[i].getIdDinossauro());
        
        str += ", Race: " + dino[i].getNomeRaca();
        
        str += ", Type: " + String.valueOf(dino[i].getTipo());

        str += ", Category: " + String.valueOf(dino[i].getCategoria());
        
        str += ", Weight: " + String.valueOf(dino[i].getPeso());
        
        return str;
    }

    public static Dinossauro[] heavyWeight(String a, String b)
    {
        int type = Integer.parseInt(a);

        int category = Integer.parseInt(b);

        double weight = 0;  

        for(int i = 0; i < cadastro.proximaPosicao; i++)
        {
            if(cadastro.cadastroDinossauros[i].getTipo() == type && cadastro.cadastroDinossauros[i].getCategoria() == category)
            {
                if(cadastro.cadastroDinossauros[i].getPeso() > weight)
                {
                    weight = cadastro.cadastroDinossauros[i].getPeso();
                }
            }
        }

        int count = 0;

        for(int i = 0; i < cadastro.proximaPosicao; i++)
        {
            if(cadastro.cadastroDinossauros[i].getPeso() == weight)
            {
                count++;
            }
        }

        Dinossauro[] dino = new Dinossauro[count];
        
        int i = 0;

        while(i < count)
        {
            for(int j = 0; j < cadastro.proximaPosicao; j++)
            {
                if(cadastro.cadastroDinossauros[j].getPeso() == weight)
                {
                    dino[i] = cadastro.cadastroDinossauros[j];

                    i++;
                }
            }
        }

        return dino;
    }

    public static String food()
    {        
        double food = 0;

        for(int i = 0; i < cadastro.proximaPosicao; i++)
        {
            if(cadastro.cadastroDinossauros[i].getCategoria() != 1)
            {
                if(cadastro.cadastroDinossauros[i].getCategoria() != 2)
                {
                    food += cadastro.cadastroDinossauros[i].getPeso() * 0.2;
                }
                else
                {
                    food += cadastro.cadastroDinossauros[i].getPeso() * 0.15;
                }
            }
            else
            {
                food += cadastro.cadastroDinossauros[i].getPeso() * 0.1;
            }
        }

        food = food * 30;

        DecimalFormat df = new DecimalFormat("#.###");

        String str = df.format(food);

        str += "kg of food required";
    
        return str;
    }

    public static boolean runAway(String a, String b, String c)
    {
        double dDino = Double.parseDouble(a);

        double dHuman = Double.parseDouble(b);

        double vDino = Double.parseDouble(c);

        double timeDino = dDino / vDino;

        double timeHuman = dHuman / 20;
        
        if(timeHuman < timeDino)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void escapeRep(String a, String b, String c)
    {
        if(a.equals("") || b.equals("")|| c.equals(""))
        {
            TF.loadErrorDATA();
        }
        else
        {
            boolean escape = runAway(a, b, c);
    
            if(escape)
            {
                TF.loadSafe();
            }
            else
            {
                TF.loadDead();
            }
        }
    }

    public static String dangerZone()
    {
        int north = 0;

        int south = 0;
        
        for(int x = 0; x < zoo.length; x++)
        {
            for(int y = 0; y < zoo.length/2; y++)
            {
                if(zoo[x][y] != 0)
                {
                    north++;
                }
            }

            for(int y = zoo.length/2; y < zoo.length; y++)
            {
                if(zoo[x][y] != 0)
                {
                    south++;
                }
            }
        }

        if(north != south)
        {
            if(north > south)
            {
                return "Most dangerous zone: NORTH";
            }
            else
            {
                return "Most dangerous zone: SOUTH";
            }
        }
        else
        {
            if(north == 0)
            {
                return "No Dinosaurs Positioned";
            }
            else
            {
                return "Same amount of carnivores in NORTH and SOUTH";
            }
        }
    }

    public static String[] raceVowel()
    {
        int max_vowel = vowelQuant();

        int raceQ_maxVowel = raceMaxVowel(max_vowel);

        String[] races = new String[raceQ_maxVowel];

        int pos = 0;

        for(int i = 0; i < nomeRaca.length; i++)
        {
            int count = 0;

            if(nomeRaca[i] != null)
            {
                for(int j = 0; j < nomeRaca[i].length(); j++)
                {
                    for(int h = 0; h < vowel.length; h++)
                    {
                        if(nomeRaca[i].charAt(j) == vowel[h])
                        {
                            count++;
    
                            break;
                        }
                    }
                }
            
                if(count == max_vowel)
                {
                    races[pos] = nomeRaca[i];

                    pos++;
                }

                count = 0;
            }
        }

        Arrays.sort(races);

        return races;
    }

    public static int vowelQuant()
    {
        int max_vowel = 0;

        int count = 0;

        for(int i = 0; i < nomeRaca.length; i++)
        {
            if(nomeRaca[i] != null)
            {
                for(int j = 0; j < nomeRaca[i].length(); j++)
                {
                    for(int h = 0; h < vowel.length; h++)
                    {
                        if(nomeRaca[i].charAt(j) == vowel[h])
                        {
                            count++;
    
                            break;
                        }
                    }
                }
               
                if(count > max_vowel)
                {
                    max_vowel = count;
                }

                count = 0;
            }
        }

        return max_vowel;
    }

    public static int raceMaxVowel(int max)
    {
        int count = 0;

        int quantity = 0;

        for(int i = 0; i < nomeRaca.length; i++)
        {
            if(nomeRaca[i] != null)
            {
                for(int j = 0; j < nomeRaca[i].length(); j++)
                {
                    for(int h = 0; h < vowel.length; h++)
                    {
                        if(nomeRaca[i].charAt(j) == vowel[h])
                        {
                            count++;
    
                            break;
                        }
                    }
                }
               
                if(count == max)
                {
                    quantity++;
                }

                count = 0;
            }
        }
        
        return quantity;
    }
}