package org.ednovo.gooru.shared.model.library;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class PartnerConceptListDo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.Integer getCount(org.ednovo.gooru.shared.model.library.PartnerConceptListDo instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.PartnerConceptListDo.class, instance, "count");
  }
  
  private static void setCount(org.ednovo.gooru.shared.model.library.PartnerConceptListDo instance, java.lang.Integer value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.PartnerConceptListDo.class, instance, "count", value);
  }
  
  private static java.util.ArrayList getSearchResult(org.ednovo.gooru.shared.model.library.PartnerConceptListDo instance) {
    return (java.util.ArrayList) ReflectionHelper.getField(org.ednovo.gooru.shared.model.library.PartnerConceptListDo.class, instance, "searchResult");
  }
  
  private static void setSearchResult(org.ednovo.gooru.shared.model.library.PartnerConceptListDo instance, java.util.ArrayList value) 
  {
    ReflectionHelper.setField(org.ednovo.gooru.shared.model.library.PartnerConceptListDo.class, instance, "searchResult", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.ednovo.gooru.shared.model.library.PartnerConceptListDo instance) throws SerializationException {
    setCount(instance, (java.lang.Integer) streamReader.readObject());
    setSearchResult(instance, (java.util.ArrayList) streamReader.readObject());
    
  }
  
  public static org.ednovo.gooru.shared.model.library.PartnerConceptListDo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.ednovo.gooru.shared.model.library.PartnerConceptListDo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.ednovo.gooru.shared.model.library.PartnerConceptListDo instance) throws SerializationException {
    streamWriter.writeObject(getCount(instance));
    streamWriter.writeObject(getSearchResult(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.ednovo.gooru.shared.model.library.PartnerConceptListDo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.PartnerConceptListDo_FieldSerializer.deserialize(reader, (org.ednovo.gooru.shared.model.library.PartnerConceptListDo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.ednovo.gooru.shared.model.library.PartnerConceptListDo_FieldSerializer.serialize(writer, (org.ednovo.gooru.shared.model.library.PartnerConceptListDo)object);
  }
  
}