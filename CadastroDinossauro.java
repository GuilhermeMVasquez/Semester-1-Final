public class CadastroDinossauro
{
    Dinossauro[] cadastroDinossauros;
    
    int proximaPosicao;

    int tamanho = 5;
    
    public CadastroDinossauro()
    {
        cadastroDinossauros = new Dinossauro[tamanho];
    
        proximaPosicao = 0;
    }
    
    public boolean adicionarDinossauro(Dinossauro dino)
    {
        if(proximaPosicao < cadastroDinossauros.length)
        { 
            cadastroDinossauros[proximaPosicao] = dino;
            
            proximaPosicao++;
            
            return true;
        } 
        else 
        {
            System.out.println("Index out of range proximaPosicao >= cadastroDinossauros");

            return false;
        }
    }
    
    public Dinossauro pesquisarDinossauro(int id)
    {
        for(int i = 0; i < proximaPosicao; i++)
        {
            if(cadastroDinossauros[i].getIdDinossauro() == id)
            {
                return cadastroDinossauros[i];
            }
        }
        
        return null;
    }

    public Dinossauro findDinossauro(double weight)
    {
        for(int i = 0; i < proximaPosicao; i++)
        {
            if(cadastroDinossauros[i].getPeso() == weight)
            {
                return cadastroDinossauros[i];
            }
        }
        
        return null;
    }

    public boolean contemDinossauro(int id)
    {
        for(int i = 0; i < proximaPosicao; i++)
        {
            if(cadastroDinossauros[i].getIdDinossauro() == id)
            {
                return true;
            }
        }

        return false;
    }
    
    public boolean removerDinossauro(int id)
    {
        for(int i = 0; i < proximaPosicao; i++)
        {
            if(cadastroDinossauros[i].getIdDinossauro() == id)
            {
                cadastroDinossauros[i] = null;
                
                for(int j = i; j < proximaPosicao - 1; j++)
                {
                    cadastroDinossauros[j] = cadastroDinossauros[j+1];
                }

                cadastroDinossauros[proximaPosicao-1] = null;
                
                proximaPosicao--;

                return true;
            }
        }
    
        return false;
    }
}