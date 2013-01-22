package erp.nfe;

import br.inf.portalfiscal.nfe.TNfeProc;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 * Teste para NFe.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (22/01/2013 14:36)
 */
public class ErpNfe {

    public static void main(String[] args) throws Exception {
        TNfeProc nfe = JAXB.unmarshal(new File("c:/NFe35130162236146000198550020000557241000557240-procNFe.xml"), TNfeProc.class);
        JAXBContext context = JAXBContext.newInstance("br.inf.portalfiscal.nfe");
        Marshaller m = context.createMarshaller();

        StringWriter sw = new StringWriter();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE); 
        m.marshal(nfe, sw);
        
        String xml = sw.getBuffer().toString();
        xml = xml.replace("xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\" ", "");
        xml = xml.replace("ns2:", "");
        xml = xml.replace("<Signature>", "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">");
        PrintWriter pw = new PrintWriter("c:/out.xml");
        pw.print(xml);
        pw.close();
        
        //m.marshal(nfe, new File("c:/copiaprocnfe.xml"));
        
        
//        System.out.println(nfe.getInfNFe().getDet().get(0).getProd().getComb().getCIDE());
    }
}
