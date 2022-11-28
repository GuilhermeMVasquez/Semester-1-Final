public class Dinossauro
{    
    private int idDinossauro; //ID do dinossauro. Cada dinossauro possui um ID único. 
    
    private String nomeRaca; //nome da raça do dinossauro    
    
    private int tipo; //1 para carnívoros, 2 para herbívoros.
    
    private int categoria;//1 para Pequeno Porte, 2 para Médio Porte, 3 para grande porte.
    
    private double peso;//peso do dinossauro
    
    public Dinossauro(int idDinossauro, String nomeRaca, int tipo, int categoria, double peso)
    {
        this.idDinossauro = idDinossauro;
        
        this.nomeRaca = nomeRaca; 
        
        this.tipo = tipo;
        
        this.categoria = categoria;
        
        this.peso = peso;
    }
    
    public void setIdDinossauro(int idDinossauro)
    {
        this.idDinossauro = idDinossauro;
    }
    
    public int getIdDinossauro()
    {
        return idDinossauro;
    }
    
    public void setNomeRaca(String nomeRaca)
    {
        this.nomeRaca = nomeRaca;
    }

    public String getNomeRaca()
    {
        return nomeRaca;
    }    
    
    public void setCategoria(int categoria)
    {
        this.categoria = categoria;
    }
    
    public int getCategoria()
    {
        return categoria;
    }
    
    public void setPeso(double peso)
    {
        this.peso = peso;
    } 
    
    public double getPeso()
    {
        return peso;
    }
    
    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }
    
    public int getTipo()
    {
        return tipo;
    }
}