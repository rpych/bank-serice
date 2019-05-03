package ice_bank.stock_exchange;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import stock.StockExchangeGrpc;
import stock.stockRequest;
import stock.stockResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import stock.currency;

public class BankStockExchangeService{

	
	private ManagedChannel channel;
	private StockExchangeGrpc.StockExchangeBlockingStub blockingStub;
	public BankStockExchangeService(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
	}
	
	private BankStockExchangeService(ManagedChannel channel){
		this.channel = channel; 
		blockingStub = StockExchangeGrpc.newBlockingStub(channel);
	}
	
	public void shutdown() throws InterruptedException {
	    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	
	
	public Double runStockExchangeService(stockRequest currencies) {
		stockResponse updatedCurrencies = blockingStub.getUpdatedCurrencies(currencies);
		Double result = updatedCurrencies.getUpdatedCurrencies(0).getValue();
		return result;
	}
	
	
}
