<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="tn.enis.dao.ProjetDAO,tn.enis.dao.ProjetDAOImpl
                        ,tn.enis.model.projet.ProjetService,tn.enis.model.projet.ProjetServiceImpl, tn.enis.model.projet.Projet, java.util.*,
                        tn.enis.dao.TacheDAO,tn.enis.dao.TacheDAOImpl
                        ,tn.enis.model.tache.TacheService,tn.enis.model.tache.TacheServiceImpl, tn.enis.model.tache.Tache"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Gestion Projet</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<h class="navbar-brand">Gestion Projets </h>
			</div>

			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a href="#myModalAjout" data-toggle="modal"><i
								class="fa fa-dashboard fa-fw"></i> Nouveau projet</a></li>

						<%
							ProjetDAO projetDao =new ProjetDAOImpl();
															ProjetService service = new ProjetServiceImpl(projetDao);
																List<Projet> liste = service.findAll();
																for (Projet projet : liste) {
						%>
						<li><a href='Servlet?id=<%=projet.getId_projet()%>'>
						<i class="fa fa-table fa-fw"></i> <%=(String) projet.getNom_projet()%></a>

						</li>
						<%
							}
						%>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="page-header">
					<h1>
					<%Projet projet=(Projet)session.getAttribute("projet"); %>
						<%=projet.getNom_projet()%>
					</h1>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Taches du projet :</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>description du tache</th>
										<th>durée</th>
										<th></th>

									</tr>
								</thead>
								<tbody>
									<%
										List<Tache> taches = (List<Tache>)session.getAttribute("taches");
																						for (Tache tache : taches) {
									%>
									<tr class="odd gradeX">
										<td><%=tache.getDescription()%></td>
										<td><%=tache.getDuree()%></td>
										<td><a href='#myModalUpdateTache' data-toggle="modal"
											class="xcrud-action btn btn-info btn-sm" title="Modifier"
											href="javascript:;" data-primary="1" data-task="view"> <i
												class="fa fa-edit"></i></a> <a href='#myModal'
											data-toggle="modal"
											class="xcrud-action btn btn-danger btn-sm" title="Supprimer"
											href="javascript:;" data-primary="1" data-task="view"><i
												class="fa fa-trash-o"></i></a></td>
									</tr>
									<%
										}
									%>


								</tbody>
							</table>

						</div>

						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
					<div style="text-align: center;">
						<button type="button" class="btn btn-warning btn-circle btn-lg" data-toggle="modal" 
						data-target="#myModalUpdateProject">
							<i class="fa fa-link" ></i>
						</button>
						<button type="button" class="btn btn-danger btn-circle btn-lg"
							data-toggle="modal" data-target="#myModalProjet" >
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>

			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>


	<!-- modal ajout-->
	<div class="modal fade" id="myModalAjout" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Ajouter un projet</h4>
				</div>

				<div class="modal-body">

					<form id="formUpdate" class="form-horizontal" role="form" action="Servlet">
						<div class="form-group">
							<label class="col-sm-2 control-label" >Nom </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="nomProjet"
									name="nomProjet">
							</div>
						
						</div>



						<div class="modal-footer">
							<button type="submit" class="btn btn-default">Ajouter</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal" onclick="location.reload()">Fermer</button>
						</div>

					</form>
				</div>
				<div id="addResp"></div>

			</div>

		</div>
	</div>

	<!-- modal update-->
	<div class="modal fade" id="myModalUpdateProject" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modifier un projet</h4>
				</div>

				<div class="modal-body">

					<form id="formUpdate" class="form-horizontal" role="form" action="Servlet">
						<div class="form-group">
							<label class="col-sm-2 control-label">Nom </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="nomProjet"
									name="nomProjetAmodifier">
								<input type="hidden" name="idProjetAmodifier" value="<%= projet.getId_projet()%>"/>
							</div>
						</div>

						<div class="modal-footer">
							<button type="submit" class="btn btn-default" >Modifier</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal" onclick="location.reload()">Fermer</button>
						</div>

					</form>
				</div>
				<div id="addResp"></div>

			</div>

		</div>
	</div>

	<!-- modal update tache-->
	<div class="modal fade" id="myModalUpdateTache" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modifier une tache</h4>
				</div>

				<div class="modal-body">

					<form id="formUpdate" class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-sm-2 control-label">Description </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="description"
									name="description">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">Durée </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="duree" name="duree">
							</div>
						</div>

						<div class="modal-footer">
							<button type="submit" class="btn btn-default">Modifier</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal" onclick="location.reload()">Fermer</button>
						</div>

					</form>
				</div>
				<div id="addResp"></div>

			</div>

		</div>
	</div>

	<!-- modal supprimer -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<div class="alert alert-danger alert-dismissible fade in"
				role="alert">


				<button type="button" onclick="location.reload()" class="close"
					data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">x</span>
				</button>
				<h4 id="oh-snap!-you-got-an-error!">
					Attention !<a class="anchorjs-link"
						href="#oh-snap!-you-got-an-error!"><span class="anchorjs-icon"></span></a>
				</h4>
				<p>Voulez vous vraiment supprimer cette tache ?</p>
				<p>
					<button type="button" class="btn btn-danger" name="submitDelete">Supprimer</button>
					<button type="reset" onclick="location.reload()"
						class="btn btn-link">Annuler</button>
				</p>

			</div>

		</div>
	</div>

	<!-- modal supprimer -->
	<div class="modal fade" id="myModalProjet" role="dialog">
		<div class="modal-dialog">
			<div class="alert alert-danger alert-dismissible fade in"
				role="alert">


				<button type="button" onclick="location.reload()" class="close"
					data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">x</span>
				</button>
				<h4 id="oh-snap!-you-got-an-error!">
					Attention !<a class="anchorjs-link"
						href="#oh-snap!-you-got-an-error!"><span class="anchorjs-icon"></span></a>
				</h4>
				<p>Voulez vous vraiment supprimer ce projet ?</p>
				<p>
					<a href="Servlet?idSupp=<%=projet.getId_projet()%>" type="button" class="btn btn-danger" name="submitDelete">Supprimer</a>
					<a type="reset" onclick="location.reload()"
						class="btn btn-link">Annuler</a>
				</p>

			</div>

		</div>
	</div>



	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->

	<script
		src="${pageContext.request.contextPath}/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>

</body>
</html>
