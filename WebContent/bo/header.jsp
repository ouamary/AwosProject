<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

    <!-- Header starts -->
    <div class="row-fluid">
        <div class="span12">

            <div class="header-top">

                <div class="header-wrapper">

                    <a href="${boURL}" class="utopia-logo"><img src="${boAssetsURL}logo.png" alt="Utopia"></a>

                    <div class="header-right">

                        <div class="header-divider">&nbsp;</div>

                        <div class="search-panel header-divider">
                            <div class="search-box">
                                <img src="${boAssetsURL}zoom.png" alt="Search">
                                <form action="" method="post">
                                    <input type="text" name="search" placeholder="search">
                                </form>
                            </div>
                        </div>

                        <div class="user-panel header-divider">
                            <div class="user-info">
                                <img src="${boAssetsURL}user.png" alt="">
                                <a href="http://utopiaadmin.themio.net/dashboard.html#"><security:authentication property="user.prenom"/> <security:authentication property="user.nom"/></a>
                            </div>

                            <div class="user-dropbox" style="display: none;">
                                <ul>
                                    <li class="user"><a href="">Profile</a></li>
                                    <li class="logout"><a href="${boURL}logout.html">Logout</a></li>
                                </ul>
                            </div>

                        </div><!-- User panel end -->

                    </div><!-- End header right -->

                </div><!-- End header wrapper -->

            </div><!-- End header -->

        </div>

    </div>

    <!-- Header ends -->