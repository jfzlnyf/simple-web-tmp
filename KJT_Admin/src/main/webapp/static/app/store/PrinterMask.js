/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-21
 */
Ext.define('Admin.store.PrinterMask', {
    extend: 'Ext.data.ArrayStore',
    fields: ['id', 'name'],
    data: [
        [1, "Front Desk Only"],
        [2, "Fryer Printer Only"],
        [3, "Front Desk and Fryer Printer"],
        [4, "Kitchen Printer Only"],
        [5, "Front Desk and Kitchen Printer"],
        [6, "Fryer Printer and Kitchen Printer"],
        [7, "All Printers"]
    ],
    autoLoad: true
});
