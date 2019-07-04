    $('#category-dataTable').DataTable({
    	ajax: '/admin/category/datatable',
        serverSide: true,
        columns: [
            {
                data: 'categoryId', title: '#'
            },
            {
                data: 'name', title: 'Name'
            },
            {
                data: 'sortorder', title: 'SortOrder'
            },
            {
            	data: 'categoryParent.name', title: 'Parent'
            },
            {
            	data: 'status', title : 'Status'
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
                     return '<a href="/admin/category/edit?categoryId=' + data.categoryId + '" style="margin-left: 5px" class="btn btn-sm btn-warning" data-toggle="tooltip" data-original-title="edit"><i class="fa fa-pencil-alt"></i></a>'
                     +'<button id="category-detail" style="margin-left: 5px" class="btn btn-sm btn-info" value="'+ data.categoryId + '" data-toggle="tooltip" data-original-title="detail"><i class="fa fa-align-justify"></i></button>'
                     +'<button id="category-delete" style="margin-left: 5px" class="btn btn-sm btn-danger" value="'+ data.categoryId + '" data-toggle="tooltip" data-original-title="delete"><i class="fa fa-trash"></i></button>';
                 }
             }
          ],
    });
	
	$('body').on('click', '#category-delete', function(e) {
		let categoryId = $(this).val();
		$.ajax({
			type : "DELETE",
			url : "/admin/category/delete?categoryId=" + categoryId ,
			global : false,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(data) {
				
				$('#category-dataTable').DataTable().ajax.reload();
				
				toastr.success('Xóa Book', data.message, {
					closeButton : true
				});
				console.log(data);
				
			},
			error : function(error) {
				console.log(error);
			}
		});
	});
    
