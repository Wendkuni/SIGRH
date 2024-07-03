package net.gestion.pgcongeabsence.common.util;


import net.gestion.pgcongeabsence.common.constant.Money;

public class HumanReadable {
	
	public static String getHumanReadableMoney(Integer d) {
		 String sm ="";
		 String sc ="";
		 String smi ="";
		 int centaine=d%1000;
		 if(centaine>0) sc = getURM(centaine);
		 d=d/1000;
		 int millier=d%1000;
		 if(millier>0) sm = getURM(millier);
		 d=d/1000;
		 int million=d%1000;
		 if(million>0) smi = getURM(million);
		 d=d/1000;
		 smi=smi!=""?million!=1?smi+" Millions ":" Million ":"";
		 sm=sm!=""?  millier!=1?sm+" Milles ":" Mille ":" ";
		 return smi+sm+sc;
		 
	 }
	 public static String getURM(Integer d) {
		 int unites=d%10;
		 d=d/10;
		 int dizaine=d%10;
		 d=d/10;
		 int centaine=d%10;
		 String cent = centaine>1? Money.getGenderByCode(centaine).getText()+" Cent ":centaine==1?" Cent ":"";
		 String dix =dizaine>1?Money.getGenderByCode(dizaine*10).getText()+" ":dizaine==1?Money.getGenderByCode(dizaine*10+unites).getText():"";
		 String un=dizaine==1||unites==0?"":Money.getGenderByCode(unites).getText();
		 return cent+dix+un;
	 }
}
