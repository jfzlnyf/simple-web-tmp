/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-20
 */
Ext.define('Admin.view.CloneRestaurant', {
    extend: 'Ext.window.Window',
    alias: 'widget.clone-restaurant',
    width:350,
    height:135,
    title: 'Clone Restaurant',
    modal: true,
    items: [
        {
            xtype: 'form',
            border: false,
            bodyPadding: '10 10 6 10',

            items: [
                {
                    xtype: 'combobox',
                    fieldLabel: 'From',
                    width:300,
                    editable: false,
                    store: 'Restaurant',
                    name: 'from',
                    queryMode: 'local',
                    valueField: 'rid',
                    displayField: 'enName'
                },
                {
                    xtype: 'combobox',
                    fieldLabel: 'To',
                    width:300,
                    editable: false,
                    store: 'Restaurant',
                    name: 'to',
                    queryMode: 'local',
                    valueField: 'rid',
                    displayField: 'enName'
                }
            ]
        }
    ],
    buttons: [
        {
            text: 'Clone',
            action: 'clone'
        }
    ],
    initComponent: function () {
        this.callParent(arguments);
    }
});
