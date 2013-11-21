/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.model.Restaurant', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'rowid', defaultValue: null },
        { name: 'rid', defaultValue: null },
        { name: 'enName', defaultValue: null },
        { name: 'cnName', defaultValue: null },
        { name: 'exName', defaultValue: null },
        { name: 'status', type: 'string', defaultValue: 'open' },
        { name: 'openTime', defaultValue: null },
        { name: 'rejectTime', defaultValue: null },
        { name: 'closeTime', defaultValue: null },
        { name: 'hasLunchSpecial', type: 'boolean', defaultValue: true },
        { name: 'hasDinnerSpecial', type: 'boolean', defaultValue: true },
        { name: 'hasComboApp', type: 'boolean', defaultValue: true },
        { name: 'printMethod', defaultValue: null },
        { name: 'dishTax', defaultValue: null },
        { name: 'deliverTax', defaultValue: null },
        { name: 'deliveryFee', defaultValue: null },
        { name: 'minimumDelivery', defaultValue: null },
        { name: 'forwardedPhone', defaultValue: null },
        { name: 'contactPhone1', defaultValue: null },
        { name: 'contactPhone2', defaultValue: null },
        { name: 'fax', defaultValue: null },
        { name: 'address1', defaultValue: null },
        { name: 'address2', defaultValue: null },
        { name: 'city', defaultValue: null },
        { name: 'state', defaultValue: null },
        { name: 'zipcode', defaultValue: null },
        { name: 'hourText', defaultValue: null },
        { name: 'website', defaultValue: null },
        { name: 'publicKey', defaultValue: null },
        { name: 'creditCards', defaultValue: null },
        { name: 'comment', defaultValue: null },
        { name: 'createTime', defaultValue: null },
        { name: 'updateTime', defaultValue: null }
    ]
});