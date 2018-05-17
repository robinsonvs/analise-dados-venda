package br.com.digitec.analise.dados.venda;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import br.com.digitec.analise.dados.venda.starter.Starter;

public class Main 
{
    public static void main( String[] args )
    {
        executar();  
    }

	private static void executar() {
		Starter starter = new Starter();
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
        executor.scheduleWithFixedDelay(new Runnable() {
        	public void run() {
        		starter.executar();
            }
        }, 0, 2000, TimeUnit.MILLISECONDS);
    }
}
