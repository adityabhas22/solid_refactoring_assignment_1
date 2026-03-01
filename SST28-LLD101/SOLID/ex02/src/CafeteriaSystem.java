import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStore store;
    private final TaxRule tax;
    private final DiscountRule discount;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(InvoiceStore store, TaxRule tax, DiscountRule discount) {
        this.store = store;
        this.tax = tax;
        this.discount = discount;
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = 0.0;
        for (OrderLine l : lines) subtotal += menu.get(l.itemId).price * l.qty;

        double taxPct = tax.taxPercent(customerType);
        double taxAmt = subtotal * (taxPct / 100.0);
        double disc = discount.discountAmount(customerType, subtotal, lines.size());
        double total = subtotal + taxAmt - disc;

        String invoice = InvoiceFormatter.format(invId, menu, lines, subtotal, taxPct, taxAmt, disc, total);
        System.out.print(invoice);

        store.save(invId, invoice);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
