// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stock.proto

package stock;

public interface stockResponseOrBuilder
    extends com.google.protobuf.MessageOrBuilder {

  // repeated .stock.currencyData updatedCurrencies = 1;
  /**
   * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
   */
  java.util.List<stock.currencyData> 
      getUpdatedCurrenciesList();
  /**
   * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
   */
  stock.currencyData getUpdatedCurrencies(int index);
  /**
   * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
   */
  int getUpdatedCurrenciesCount();
  /**
   * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
   */
  java.util.List<? extends stock.currencyDataOrBuilder> 
      getUpdatedCurrenciesOrBuilderList();
  /**
   * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
   */
  stock.currencyDataOrBuilder getUpdatedCurrenciesOrBuilder(
      int index);
}
