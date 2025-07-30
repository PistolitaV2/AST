//package net.codejava.ws.axis2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;


/**
 * This program demonstrates consuming a web service by a RCP-based client.
 *
 * @author www.codejava.net
 */
public class Cliente2 {
    public static void main(String[] args1) throws AxisFault {
        try {
            System.out.println("Escriba a operación (sumar/restar/multiplicar/dividir) e os operandos: ");
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
	    String linea = br.readLine();
	    String argumentos[] = linea.split(" ");
	    // String operacion = br.readLine();
	    String operacion = argumentos[0];
	    int arg0 = Integer.parseInt(argumentos[1]);
	    int arg1 = Integer.parseInt(argumentos[2]);
	    
            RPCServiceClient serviceClient = new RPCServiceClient();
            Options options = serviceClient.getOptions();
            EndpointReference targetEPR = new EndpointReference(
                    "http://localhost:8080/axis2/services/Calculadora/" + operacion + "?args0=" + arg0 + "&args1=" + arg1); // ?operacion
            options.setTo(targetEPR);
            QName opSum, opDividir, opMult, opRest = null;
            Object[] opSumArgs, opRestArgs, opMultArgs, opDividirArgs;
            Object[] response = null;
            // Object[] responsesum,responseres, responsemult,responsediv;
	    //Integer result;
	    Class[] returnTypes = new Class[] { Integer.class };
            Class[] returnTypesDividir = new Class[] { Double.class };

            switch (operacion) {
                case "sumar":
                    opSum = new QName("http://ws.apache.org/axis2", "sumar");
                    opSumArgs = new Object[] {arg0, arg1};
	       
                    response = serviceClient.invokeBlocking(opSum, opSumArgs, returnTypes);
                    break;
                case "restar":
                    opRest = new QName("http://ws.apache.org/axis2", "restar");
                    opRestArgs = new Object[] {arg0, arg1};
                    response = serviceClient.invokeBlocking(opRest, opRestArgs, returnTypes);
                    break;
                case "multiplicar":
                    opMult = new QName("http://ws.apache.org/axis2", "multiplicar");
                    opMultArgs = new Object[] {arg0, arg1 };
                    response = serviceClient.invokeBlocking(opMult, opMultArgs, returnTypes);
                    break;
                case "dividir":
                    opDividir = new QName("http://ws.apache.org/axis2", "dividir");
                    opDividirArgs = new Object[] {arg0,arg1};
                    response = serviceClient.invokeBlocking(opDividir, opDividirArgs, returnTypesDividir);
                    break;
            }

	    System.out.println("El resultado es: " + response[0]);
		// result = (Integer) response[0];
	      
            /*
             * Class[] returnTypes = new Class[] { Integer.class }; Class[]
             * returnTypesDividir = new Class[] { Double.class };
             */

            /*
             * Object[] responsesum = serviceClient.invokeBlocking(opSum, opSumArgs,
             * returnTypes); Object[] responseres = serviceClient.invokeBlocking(opRest,
             * opRestArgs, returnTypes); Object[] responsemult =
             * serviceClient.invokeBlocking(opMult, opMultArgs, returnTypes); Object[]
             * responsediv = serviceClient.invokeBlocking(opDividir, opDividirArgs,
             * returnTypesDividir);
             */
	    
            if (response[0] == null) {
                System.out.println("CalculatorService didn't initialize!");
                return;
	    }
	
	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * QName opSum = new QName("http://axis2.ws.codejava.net", "sumar");
 * 
 * Object[] opSumArgs = new Object[] { new Integer(99), new Integer(28) };
 * 
 * QName opResta = new QName("http://axis2.ws.codejava.net", "restar");
 * 
 * Object[] opRestaArgs = new Object[] { new Integer(99), new Integer(28) };
 * 
 * QName opMultiplicar = new QName("http://axis2.ws.codejava.net",
 * "multiplicar");
 * 
 * Object[] opMultArgs = new Object[] { new Integer(99), new Integer(28) };
 * 
 * QName opDividir = new QName("http://axis2.ws.codejava.net", "dividir");
 * 
 * Object[] opDividirArgs = new Object[] { new Integer(99), new Integer(28) };
 */

// Class[] returnTypes = new Class[] { Integer.class };

// Object[] response = serviceClient.invokeBlocking(opSum, opSumArgs,
// returnTypes);
