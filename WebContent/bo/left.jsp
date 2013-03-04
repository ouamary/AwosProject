<!-- Sidebar statrt -->
        <div class="span2 sidebar-container">

            <div class="sidebar">

                <div class="navbar sidebar-toggle">
                    <div class="container">

                        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </a>

                    </div>
                </div>

                <div class="nav-collapse collapse leftmenu">
					<!-- Ajouter class="current" à l'élément courant -->
                    <ul>
                        <li><a class="dashboard smronju" href="${boURL}" title="Dashboard"><span><em>Dashboard</em></span></a></li>
                        <li><a class="list" href="javascript:void(0)" title="Artistes"><span><em>Administrateurs</em></span></a>
                            <ul class="dropdown" style="left: 303px;">
                                <li><a class="tables" href="${boActionURL}admins" title="Ajouter"><span><em>Ajouter</em></span></a></li>
                                <li><a class="widgets smronju" href="${boActionURL}admin/admins" title="Tableau"><span><em>Tableau</em></span></a></li>
                            </ul>
                        </li>
                        <li><a class="media" href="javascript:void(0)" title="Albums"><span><em>Albums</em></span></a>
                            <ul class="dropdown" style="left: 303px;">
                                <li><a class="tables" href="${boActionURL}album" title="Ajouter"><span><em>Ajouter</em></span></a></li>
                                <li><a class="widgets smronju" href="${boActionURL}admin/album" title="Tableau"><span><em>Tableau</em></span></a></li>
                            </ul>
                        </li>
                        <li><a class="users" href="javascript:void(0)" title="Artistes"><span><em>Artistes</em></span></a>
                            <ul class="dropdown" style="left: 303px;">
                                <li><a class="tables" href="${boActionURL}artiste" title="Ajouter"><span><em>Ajouter</em></span></a></li>
                                <li><a class="widgets smronju" href="${boActionURL}admin/artiste" title="Tableau"><span><em>Tableau</em></span></a></li>
                            </ul>
                        </li>
                    	<li><a class="list" href="javascript:void(0)" title="Catégories"><span><em>Catégories</em></span></a>
                            <ul class="dropdown" style="left: 303px;">
                                <li><a class="tables" href="${boActionURL}categorie" title="Ajouter"><span><em>Ajouter</em></span></a></li>
                                <li><a class="widgets smronju" href="${boActionURL}admin/categorie" title="Tableau"><span><em>Tableau</em></span></a></li>
                            </ul>
                        </li>
                        <li><a class="tables" href="javascript:void(0)" title="Chansons"><span><em>Chansons</em></span></a>
                            <ul class="dropdown" style="left: 303px;">
                                <li><a class="tables" href="${boActionURL}chanson" title="Ajouter"><span><em>Ajouter</em></span></a></li>
                                <li><a class="widgets smronju" href="${boActionURL}admin/chanson" title="Tableau"><span><em>Tableau</em></span></a></li>
                            </ul>
                        </li>
                        <li>
                        	<a class="icons" href="${boActionURL}admin/client" title="Clients"><span><em>Clients</em></span></a>
                        </li>
                        <li>
                        	<a class="barcode" href="${boActionURL}admin/commande" title="Commandes"><span><em>Commandes</em></span></a>
                        </li>
					</ul>
                </div>

            </div>
        </div>
<!-- Sidebar end -->