/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.view.Dish' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.dish',
    hidden: true,
    layout: 'fit',
    itemId: 'dish',
    title: 'Dish',
    dockedItems: [
        {
            xtype: 'toolbar',
            dock: 'top',
            items: [
                {
                    text: 'New Dish',
                    handler: function () {
                    }
                }
            ]
        }
    ],
    store: 'Dish',
    selType: 'cellmodel',
    plugins: [
        Ext.create('Ext.grid.plugin.CellEditing', {
            clicksToEdit: 2
        })
    ],
    columns: [
        { text: 'rowid', dataIndex: 'rowid' },
//        { text: 'did', dataIndex: 'did' },
//        { text: 'rid', dataIndex: 'rid' },
//        { text: 'cid', dataIndex: 'cid' },
        { text: 'enName', dataIndex: 'enName', editor: 'textfield' },
        { text: 'cnName', dataIndex: 'cnName', editor: 'textfield' },
//        { text: 'exName', dataIndex: 'exName' },
        { text: 'status', dataIndex: 'status' },
        { text: 'manualPriority', dataIndex: 'manualPriority', editor: 'textfield' },
        { text: 'manualPriority2', dataIndex: 'manualPriority2', editor: 'textfield' },
        { text: 'autoPriority', dataIndex: 'autoPriority', editor: 'textfield' },
        { text: 'autoPriority2', dataIndex: 'autoPriority2', editor: 'textfield' },
        { text: 'subgroup', dataIndex: 'subgroup', editor: 'textfield' },
        { text: 'size1', dataIndex: 'size1', editor: 'textfield' },
        { text: 'size2', dataIndex: 'size2', editor: 'textfield' },
//        { text: 'size3', dataIndex: 'size3' },
//        { text: 'size4', dataIndex: 'size4' },
        { text: 'lunchSpecial', dataIndex: 'lunchSpecial', editor: 'textfield' },
        { text: 'dinnerSpecial', dataIndex: 'dinnerSpecial', editor: 'textfield' },
        { text: 'printerMask', dataIndex: 'printerMask', editor: 'textfield' },
        { text: 'description', dataIndex: 'description', editor: 'textfield' }//,
//        { text: 'createTime', dataIndex: 'createTime' },
//        { text: 'updateTime', dataIndex: 'updateTime' }
    ],
    initComponent: function() {
        this.callParent(arguments);
    }
});
