/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.model.Restaurant', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'rowid', type: 'number', defaultValue: 0 },
        { name: 'rid', type: 'string', defaultValue: 1 },
        { name: 'enName', type: 'string', defaultValue: 'abc' },
        { name: 'cnName', type: 'string', defaultValue: 'abc' },
        { name: 'exName', type: 'string', defaultValue: 'abc' },
        { name: 'status', type: 'string', defaultValue: 'abc' },
        { name: 'openTime', type: 'number', defaultValue: 2 },
        { name: 'rejectTime', type: 'number', defaultValue: 2 },
        { name: 'closeTime', type: 'number', defaultValue: 2 },
        { name: 'hasLunchSpecial', type: 'boolean', defaultValue: 2 },
        { name: 'hasDinnerSpecial', type: 'boolean', defaultValue: 2 },
        { name: 'hasComboApp', type: 'boolean', defaultValue: 2 },
        { name: 'printMethod', type: 'string', defaultValue: 'abc' },
        { name: 'dishTax', type: 'number', defaultValue: 2 },
        { name: 'deliverTax', type: 'number', defaultValue: 2 },
        { name: 'deliveryFee', type: 'number', defaultValue: 2 },
        { name: 'minimumDelivery', type: 'number', defaultValue: 2 },
        { name: 'forwardedPhone', type: 'string', defaultValue: 'abc' },
        { name: 'contactPhone1', type: 'string', defaultValue: 'abc' },
        { name: 'contactPhone2', type: 'string', defaultValue: 'abc' },
        { name: 'fax', type: 'string', defaultValue: 'abc' },
        { name: 'address1', type: 'string', defaultValue: 'abc' },
        { name: 'address2', type: 'string', defaultValue: 'abc' },
        { name: 'city', type: 'string', defaultValue: 'abc' },
        { name: 'state', type: 'string', defaultValue: 'abc' },
        { name: 'zipcode', type: 'string', defaultValue: 'abc' },
        { name: 'hourText', type: 'string', defaultValue: 'abc' },
        { name: 'website', type: 'string', defaultValue: 'abc' },
        { name: 'publicKey', type: 'string', defaultValue: 'abc' },
        { name: 'creditCards', type: 'string', defaultValue: 'abc' },
        { name: 'comment', type: 'string', defaultValue: 'abc' },
        { name: 'createTime', type: 'number', defaultValue: 2 },
        { name: 'updateTime', type: 'number', defaultValue: 2 }
    ]
});
