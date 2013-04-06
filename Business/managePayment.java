package business;

import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import data_access.Access;
import data_access.Insert;
import data_access.Update;
import model.Entity;
import model.Invoice;
import model.Payment;

public class managePayment {
	Insert newInsert = new Insert();
	boolean created = false;
	int inserted =0;
	int updated = 0;
	Invoice inv = new Invoice();
	double tax = 0;
	double total = 0;
	ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	Access dataAccess = new Access();
	Update newUpdate = new Update();
	XStream xstream = new XStream(new StaxDriver());
public int createInvoice(Entity entity)
{
	
	entity.setInvoice(calcFees(entity));
	inserted = newInsert.insertInvoice(entity);
	return inserted;
}
public int processPayment(Entity entity)
{
	inserted = 0;
	newInsert.insertPayment(entity);
	return inserted;
}
public int payInvoice (Entity entity)
{
	updated = newUpdate.payInvoice(entity);
	return updated;
}
public Entity retrieveInvoices(Entity entity)
{
	invoices = dataAccess.queryInvoices(entity);
	entity.getUser().setInvoices(invoices);
	return entity;
}
public String genInvoice(Invoice invoice)
{
	xstream.alias("invoice", Invoice.class);
	String xml = xstream.toXML(invoice);
	return xml;
}
public Invoice calcFees(Entity entity)
{
	
	inv.setFirst(entity.getUser().getFirst());
	inv.setLast(entity.getUser().getLast());
	inv.setSubtotal(entity.getCourse().getPrice());
	inv.setCity(entity.getUser().getCity());
	inv.setProvince(entity.getUser().getProvince());
	tax = inv.getSubtotal() * 0.13;
	total = tax + inv.getSubtotal();
	inv.setTax(tax);
	inv.setTotal(total);
	return inv;
}
/*Added: 04/04/13 
	 * Pulls invoices from the database to display already paid  
	 * paid invoices to the user.
	 */
public ArrayList<Invoice> paidInv(Entity entity)
{
	invoices = new ArrayList<Invoice>();
	invoices = dataAccess.pullInvoices(entity);
	return invoices;
}

}
