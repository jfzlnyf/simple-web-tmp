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
                    text: 'Clone Restaurant',
                    action: 'clone'
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
        { text: 'enName', dataIndex: 'enName', editor: 'textfield',width:200 },
        {
            text: 'status',
            dataIndex: 'status',
            editor: {
                xtype: 'combobox',
                editable: false,
                store: ['open', 'closed', 'reject'],
                queryMode: 'local'
            }
        },
        {
            text: 'hasComboApp', dataIndex: 'hasComboApp',
            editor: {
                xtype: 'combobox',
                editable: false,
                store: [[true, 'true'], [false, 'false']],
                queryMode: 'local'
            }
        },
        { text: 'dishTax', dataIndex: 'dishTax', editor: 'numberfield' },
        { text: 'deliverTax', dataIndex: 'deliverTax', editor: 'numberfield' },
        { text: 'deliveryFee', dataIndex: 'deliveryFee', editor: 'numberfield' },
        { text: 'minimumDelivery', dataIndex: 'minimumDelivery', editor: 'textfield' },
        { text: 'forwardedPhone', dataIndex: 'forwardedPhone', editor: 'textfield' },
        { text: 'contactPhone1', dataIndex: 'contactPhone1', editor: 'textfield' },
        { text: 'contactPhone2', dataIndex: 'contactPhone2', editor: 'textfield' },
        { text: 'address1', dataIndex: 'address1', editor: 'textfield',width:200 },
        { text: 'address2', dataIndex: 'address2', editor: 'textfield',width:200 },
        { text: 'city', dataIndex: 'city', editor: 'textfield' },
        { text: 'state', dataIndex: 'state', editor: 'textfield' },
        { text: 'zipcode', dataIndex: 'zipcode', editor: 'textfield' }
    ]
});
