    $('#product-dataTable').DataTable({
    	ajax: '/admin/product/datatable',
        serverSide: true,
        columns: [
            {
                data: 'id', title: '#'
            },
            {
                data: 'name', title: 'Name'
            },
            {
                data: 'price', title: 'Price'
            },
            {
            	data: 'maxQuanlity', title: 'Max Quanlity'
            },
            {
            	data: 'producer', title : 'Producer'
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
					console.log("Log: "+data);
                     return '<a href="/admin/product/edit?productId=' + data.id + '" style="margin-left: 5px" class="btn btn-sm btn-warning" data-toggle="tooltip" data-original-title="edit"><i class="fa fa-pencil-alt"></i></a>'
                     +'<button id="product-detail" style="margin-left: 5px" class="btn btn-sm btn-info" value="'+ data.id + '" data-toggle="tooltip" data-original-title="detail"><i class="fa fa-align-justify"></i></button>'
                     +'<button id="product-delete" style="margin-left: 5px" class="btn btn-sm btn-danger" value="'+ data.id + '" data-toggle="tooltip" data-original-title="delete"><i class="fa fa-trash"></i></button>';
                 }
             }
          ]
    });
	
	$('body').on('click', '#product-delete', function(e) {
		let productId = $(this).val();
		$.ajax({
			type : "DELETE",
			url : "/admin/product/delete?productId=" + productId ,
			global : false,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(data) {
				
				$('#product-dataTable').DataTable().ajax.reload();
				
				toastr.success('Xóa sản phẩm', data.message, {
					closeButton : true
				});
				console.log(data);
				
			},
			error : function(error) {
				console.log(error);
			}
		});
	});
    
