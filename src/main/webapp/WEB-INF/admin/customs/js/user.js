    $('#user-dataTable').DataTable({
    	ajax: '/admin/user/datatable',
        serverSide: true,
        columns: [
            {
                data: 'userId', title: '#'
            },
            {
                data: 'firstName', title: 'First Name'
            },
            {
                data: 'lastName', title: 'Last Name'
            },
            {
            	data: 'phone', title : 'Phone'
            },
            {
            	data: 'username', title: 'UserName'
            },
            {
            	data: 'roles', title: 'Roles', 
            	render: function (data, type, full){
                	var s = "";
                	var size = data.length;
                    for (i = 0; i < size; i++) { 
                    	if(i != size - 1){
                    		s += data[i].name + " | "
                    	}else{
                    		s += data[i].name;
                    	}
                    }
                    return s;
                },
            },
            {
                data: 'status', title: 'Status'
            },
            {
            	title: 'Action'
            }
        ],
	    "aoColumnDefs": [
			 { 	"mData": null,
				"sDefaultContent": '"none"',
				"aTargets": [ "_all" ]
			 },
        	 {"sClass":  "text-center", "aTargets" : ["_all"]},
        	 { "sTitle" : "Action",
        		 "orderable": false,
        		 "bSearchable": false,
                "aTargets": [-1],
                "mRender": function (data, type, full) {
                	return '<a href="/admin/user/edit?userId=' + data.userId + '" style="margin-left: 5px" class="btn btn-sm btn-warning" data-toggle="tooltip" data-original-title="edit"><i class="fa fa-pencil-alt"></i></a>'
                    +'<button id="category-detail" style="margin-left: 5px" class="btn btn-sm btn-info" value="'+ data.userId + '" data-toggle="tooltip" data-original-title="detail"><i class="fa fa-align-justify"></i></button>'
                    +'<button id="category-delete" style="margin-left: 5px" class="btn btn-sm btn-danger" value="'+ data.userId + '" data-toggle="tooltip" data-original-title="delete"><i class="fa fa-trash"></i></button>';
                 }
             }
          ],
    });
