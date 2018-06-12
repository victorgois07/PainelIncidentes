package filesexcel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VerifiedFiles {
    public String diretorio;

    public VerifiedFiles() {
    }

    public VerifiedFiles(String diretorio) {
        this.diretorio = diretorio;
    }
    
    protected List<String> visualizarArquivos(){
        
        List<String> xlsx = new ArrayList<>();
        
	File file = new File(this.getDiretorio());
        
	File afile[] = file.listFiles();
        
	int i = 0;
        
	for (int j = afile.length; i < j; i++) {
            
            File arquivos = afile[i];
                
            xlsx.add(arquivos.getName());
            
	}
        
        if(xlsx.size() > 0){
            
            return xlsx;
            
        }else{
            
            return null;
            
        }        

    }
    
    public String fileString(){
        
        List<String> dado = this.visualizarArquivos();
        
        List<Integer> dia = new ArrayList<>();
        
        List<Integer> mes = new ArrayList<>();
        
        int d = 0, m=0;
        char sexto, setimo, oitavo, nono;
        String st = "", sd = "";
        
        for(int i=0; i < dado.size(); i++){
            
            sexto = dado.get(i).charAt(5);
            setimo = dado.get(i).charAt(6);
            
            oitavo = dado.get(i).charAt(8);
            nono = dado.get(i).charAt(9);
            
            st = ""+sexto+setimo;
            sd = ""+oitavo+nono;
            
            d = Integer.parseInt(st);
            m = Integer.parseInt(sd);
            
            dia.add(d);
            mes.add(m);
        }
        
        int  maiorDia = 0;
        
        for(int i = 0;i< dia.size(); i++){  
           if(dia.get(i) > maiorDia){ 
                maiorDia = i;  
           }  
        }
        
        int  maiorMes = 0;
        
        for(int i = 0;i< mes.size(); i++){  
           if(mes.get(i) > maiorMes){ 
                maiorMes = i;
           }  
        }
        
        String fileA = "";
        
        if(dado.get(maiorDia).equals(dado.get(maiorMes))){
            fileA = dado.get(maiorDia);
        }else{
            fileA = dado.get(maiorMes);
        }
        
        return this.getDiretorio()+"\\"+fileA;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }
    
    
}
