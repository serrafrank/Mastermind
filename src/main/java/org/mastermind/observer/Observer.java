package  org.mastermind.observer;

import java.util.List;

public interface Observer {
	public void updateInput(String s);
	public void updateOutputCompar(List<Object> o);
	public void updateOutputPropos(List<Object> o);
	public void updateRound(int o);
	public void updateInitGame(String s, List<Object> l, boolean u);
	public void updateEndGame(String e, boolean w);
}