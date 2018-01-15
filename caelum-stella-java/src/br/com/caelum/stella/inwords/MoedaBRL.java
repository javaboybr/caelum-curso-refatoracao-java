package br.com.caelum.stella.inwords;

public class MoedaBRL extends Moeda {
	
   
        protected override string MoedaSingular { get => ResourceManagerHelper.Instance.ResourceManager.GetString("MoedaBRLSingular"); }
        protected override string MoedaPlural { get => ResourceManagerHelper.Instance.ResourceManager.GetString("MoedaBRLPlural"); }

        public MoedaBRL(double numero) /*: base(numero)*/ {
        		super(numero);
        }
}
