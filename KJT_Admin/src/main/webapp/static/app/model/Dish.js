/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.model.Dish', {
    extend: 'Ext.data.Model',
    fields: [
//        { name: 'rowid', type: 'number' },
        { name: 'did', type: 'string', defaultValue: '' },
        { name: 'rid', type: 'string', defaultValue: '' },
        { name: 'cid', type: 'string', defaultValue: '' },
        { name: 'enName', type: 'string', defaultValue: '' },
        { name: 'cnName', type: 'string', defaultValue: '' },
        { name: 'exName', type: 'string', defaultValue: '' },
        { name: 'description', type: 'string', defaultValue: '' },
        { name: 'status', type: 'string', defaultValue: 'normal' },
        { name: 'manualPriority', type: 'number', defaultValue: 0 },
        { name: 'manualPriority2', type: 'number', defaultValue: 0 },
        { name: 'autoPriority', type: 'number', defaultValue: 0 },
        { name: 'autoPriority2', type: 'number', defaultValue: 0 },
        { name: 'subgroup', type: 'number', defaultValue: 1 },
        { name: 'size1', type: 'number', defaultValue: 1 },
        { name: 'size2', type: 'number', defaultValue: 1 },
        { name: 'size3', type: 'number', defaultValue: 1 },
        { name: 'size4', type: 'number', defaultValue: 1 },
        { name: 'lunchSpecial', type: 'number', defaultValue: 1 },
        { name: 'dinnerSpecial', type: 'number', defaultValue: 1 },
        { name: 'printerMask', type: 'number', defaultValue: 1 }//,
//        { name: 'createTime', type: 'number' },
//        { name: 'updateTime', type: 'number' }
    ]
});
