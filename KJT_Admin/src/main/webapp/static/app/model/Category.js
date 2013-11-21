/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.model.Category', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'cid', defaultValue: null },
        { name: 'rid', defaultValue: null },
        { name: 'enName', defaultValue: null },
        { name: 'cnName', defaultValue: null },
        { name: 'exName', defaultValue: null },
        { name: 'categoryType', type: 'string', defaultValue: 'normal' },
        { name: 'priority', defaultValue: null },
        { name: 'priority2', defaultValue: null },
        { name: 'defaultPrinterMask', defaultValue: null }
    ]
});
