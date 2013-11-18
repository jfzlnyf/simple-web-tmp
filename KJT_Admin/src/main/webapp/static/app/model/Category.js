/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.model.Category', {
    extend: 'Ext.data.Model',
    fields: [
//        { name: 'rowid', type: 'number' },
        { name: 'cid', type: 'string' },
        { name: 'rid', type: 'string' },
        { name: 'enName', type: 'string', defaultValue: '' },
        { name: 'cnName', type: 'string', defaultValue: '' },
        { name: 'exName', type: 'string', defaultValue: '' },
        { name: 'categoryType', type: 'string', defaultValue: 'normal' },
        { name: 'priority', type: 'number', defaultValue: 0 },
        { name: 'priority2', type: 'number', defaultValue: 0 },
//        { name: 'extension', type: 'string' },
        { name: 'defaultPrinterMask', type: 'number', defaultValue: 1 }
    ]
});
