package kr.co.gerion.websocket;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;
import org.json.simple.JSONObject;

public class WsClient extends WebSocketClient{

	public WsClient( URI serverUri , Draft draft ) {

		super( serverUri, draft );

	}



	public WsClient( URI serverURI ) {

		super( serverURI );

	}






	@Override

	public void onOpen( ServerHandshake handshakedata ) {

		JSONObject obj = new JSONObject();
		JSONObject obj2 = new JSONObject();
		
		obj.put("method", "subscribe");
		
		obj2.put("isuSrtCd", "005930");
		obj2.put("preset", "quote");
		
		obj.put("params", obj2);
		
		String test = obj.toString();
		System.out.println("onOpen()");
		
		
		send(test);

		System.out.println( "opened connection" );

		// if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient

	}



	@Override

	public void onMessage( String message ) {

		System.out.println( "received: " + message );

	}



	@Override

	public void onClose( int code, String reason, boolean remote ) {

		// The codecodes are documented in class org.java_websocket.framing.CloseFrame

		System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) + " Code: " + code + " Reason: " + reason );

	}



	@Override

	public void onError( Exception ex ) {

		ex.printStackTrace();

		// if the error is fatal then onClose will be called additionally

	}

	public static void main( String[] args ) throws URISyntaxException {

		
		try{
			WsClient c = new WsClient( new URI( "ws://sandbox-apigw.koscom.co.kr:9887/ws/" )); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts

			c.connect();	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		

	}
	
	
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
