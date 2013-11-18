/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.view.Restaurant' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.restaurant',
    hidden: false,
    layout: 'fit',
    itemId: 'restaurant',
    title: 'Restaurant',
    dockedItems: [
        {
            xtype: 'toolbar',
            dock: 'top',
            items: [
                {
                    text: 'New Restaurant',
                    action: 'new'
                },
                {
                    text: 'Save',
                    action: 'save'
                }
            ]
        }
    ],
    store: 'Restaurant',
    selType: 'cellmodel',
    plugins: [
        Ext.create('Ext.grid.plugin.CellEditing', {
            clicksToEdit: 2
        })
    ],
    columns: [
        { text: 'rowid', dataIndex: 'rowid', width: 40 },
//        { text: 'rid', dataIndex: 'rid', editor: 'textfield' },
        { text: 'enName', dataIndex: 'enName', editor: 'textfield' },
//        { text: 'cnName', dataIndex: 'cnName', editor: 'textfield' },
//        { text: 'exName', dataIndex: 'exName', editor: 'textfield' },
        { text: 'status', dataIndex: 'status' },
//        { text: 'openTime', dataIndex: 'openTime' },
//        { text: 'rejectTime', dataIndex: 'rejectTime' },
//        { text: 'closeTime', dataIndex: 'closeTime' },
//        { text: 'hasLunchSpecial', dataIndex: 'hasLunchSpecial' },
//        { text: 'hasDinnerSpecial', dataIndex: 'hasDinnerSpecial' },
        { text: 'hasComboApp', dataIndex: 'hasComboApp', editor: 'textfield' },
//        { text: 'printMethod', dataIndex: 'printMethod' },
        { text: 'dishTax', dataIndex: 'dishTax', editor: 'textfield' },
        { text: 'deliverTax', dataIndex: 'deliverTax', editor: 'textfield' },
        { text: 'deliveryFee', dataIndex: 'deliveryFee', editor: 'textfield' },
        { text: 'minimumDelivery', dataIndex: 'minimumDelivery', editor: 'textfield' },
        { text: 'forwardedPhone', dataIndex: 'forwardedPhone', editor: 'textfield' },
        { text: 'contactPhone1', dataIndex: 'contactPhone1', editor: 'textfield' },
        { text: 'contactPhone2', dataIndex: 'contactPhone2', editor: 'textfield' },
//        { text: 'fax', dataIndex: 'fax' },
        { text: 'address1', dataIndex: 'address1', editor: 'textfield' },
        { text: 'address2', dataIndex: 'address2', editor: 'textfield' },
        { text: 'city', dataIndex: 'city', editor: 'textfield' },
        { text: 'state', dataIndex: 'state', editor: 'textfield' },
        { text: 'zipcode', dataIndex: 'zipcode', editor: 'textfield' }//,
//        { text: 'hourText', dataIndex: 'hourText' },
//        { text: 'website', dataIndex: 'website' },
//        { text: 'publicKey', dataIndex: 'publicKey' },
//        { text: 'creditCards', dataIndex: 'creditCards' },
//        { text: 'comment', dataIndex: 'comment' },
//        { text: 'createTime', dataIndex: 'createTime' },
//        { text: 'updateTime', dataIndex: 'updateTime' }
    ]
});
