<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!--bootstrap-->
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous"
    />
    <!-- <link href="css/bootstrap-dropdownhover.min.css" rel="stylesheet" /> -->
    <!--end of the bootstrap-->

    <!--akila css-->

    <link rel="stylesheet" href="../../../css/akila/dashboard.css" />
    <!--end of the akila css-->
    <title>Admin</title>
  </head>
  <body>

    <!--end of the body part-->

    <!--footer-->

    <footer class="new_footer_area bg_color">
      <div class="new_footer_top">
        <div class="container">
          <div class="row">
            <div class="col-lg-3 col-md-6">
              <div
                class="f_widget company_widget wow fadeInLeft"
                data-wow-delay="0.2s"
                style="
                  visibility: visible;
                  animation-delay: 0.2s;
                  animation-name: fadeInLeft;
                "
              >
                <h3 class="f-title f_600 t_color f_size_18">Get in Touch</h3>
                <p>
                  Don’t miss any updates of our new templates and extensions.!
                </p>
                <form
                  action="#"
                  class="f_subscribe_two mailchimp"
                  method="post"
                  novalidate="true"
                  _lpchecked="1"
                >
                  <input
                    type="text"
                    name="EMAIL"
                    class="form-control memail"
                    placeholder="Email"
                  />
                  <button class="btn btn_get btn_get_two" type="submit">
                    Subscribe
                  </button>
                  <p class="mchimp-errmessage" style="display: none;"></p>
                  <p class="mchimp-sucmessage" style="display: none;"></p>
                </form>
              </div>
            </div>
            <div class="col-lg-3 col-md-6">
              <div
                class="f_widget about-widget pl_70 wow fadeInLeft"
                data-wow-delay="0.4s"
                style="
                  visibility: visible;
                  animation-delay: 0.4s;
                  animation-name: fadeInLeft;
                "
              >
                <h3 class="f-title f_600 t_color f_size_18">Services</h3>
                <ul class="list-unstyled f_list">
                  <li><a href="#">Packages</a></li>
                  <li><a href="#">Requexts App</a></li>
                  <li><a href="#">Status</a></li>
                  <li><a href="#">Reports</a></li>
                  <li><a href="#">Bills</a></li>
                  <li><a href="#">Notifications</a></li>
                </ul>
              </div>
            </div>
            <div class="col-lg-3 col-md-6">
              <div
                class="f_widget about-widget pl_70 wow fadeInLeft"
                data-wow-delay="0.6s"
                style="
                  visibility: visible;
                  animation-delay: 0.6s;
                  animation-name: fadeInLeft;
                "
              >
                <h3 class="f-title f_600 t_color f_size_18">
                  Navigate to other pages
                </h3>
                <ul class="list-unstyled f_list">
                  <li><a href="#">FAQ</a></li>
                  <li><a href="#">Login</a></li>
                  <li><a href="#">User Admin</a></li>
                </ul>
              </div>
            </div>
            <div class="col-lg-3 col-md-6">
              <div
                class="f_widget social-widget pl_70 wow fadeInLeft"
                data-wow-delay="0.8s"
                style="
                  visibility: visible;
                  animation-delay: 0.8s;
                  animation-name: fadeInLeft;
                "
              >
                <h3 class="f-title f_600 t_color f_size_18">Social Media</h3>
                <div class="f_social_icon">
                  <a href="#" class="fab fa-facebook"></a>
                  <a href="#" class="fab fa-twitter"></a>
                  <a href="#" class="fab fa-linkedin"></a>
                  <a href="#" class="fab fa-pinterest"></a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="footer_bg">
          <div class="footer_bg_one"></div>
          <div class="footer_bg_two"></div>
        </div>
      </div>
      <div class="footer_bottom">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-lg-6 col-sm-7">
              <p class="mb-0 f_400">
                © CarCare System Solutions All rights reserved.
              </p>
            </div>
          </div>
        </div>
      </div>
    </footer>
    <!--end of the footer-->

    <!--bootstrap-->
    <script
      src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
      integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
      integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
      integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
      crossorigin="anonymous"
    ></script>
    <!--end of the bootstrap-->

    <!--akila js-->
    <script src="js/akila/dashboard.js"></script>
    <!--end of the akila js-->

    <!--font awsome cdn-->
    <script
      src="https://kit.fontawesome.com/61a479e883.js"
      crossorigin="anonymous"
    ></script>
    <!--end of the font awsone cdn-->

    <!--chart.js-->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2/dist/Chart.min.js"></script>
    <!--end of the chart.js-->

    <!--charts-->
    <script>
      let user = document.getElementById("user").getContext("2d");

      let lineOne = new Chart(user, {
        type: "line",
        data: {
          labels: [
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednsday",
            "Thursday",
            "Friday",
            "Saturday",
          ],
          datasets: [
            {
              label: "Count",
              data: [10, 30, 1, 30, 50, 70, 90],
              backgroundColor: ["#fa163f"],
              borderColor: "#FFFF",
              borderWidth: "3px",
            },
          ],
        },
        options: {
          scales: {
            xAxes: [
              {
                gridLines: {
                  color: "rgba(0, 0, 0, 0)",
                },
              },
            ],
            yAxes: [
              {
                gridLines: {
                  display: true,
                },
              },
            ],
          },
        },
      });

      let imcome = document.getElementById("income").getContext("2d");

      let pieOne = new Chart(income, {
        type: "doughnut",
        data: {
          labels: [
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednsday",
            "Thursday",
            "Friday",
            "Saturday",
          ],
          datasets: [
            {
              label: "Count",
              data: [10, 30, 1, 30, 50, 70, 90],
              backgroundColor: [
                "#fa163f",
                "#f0134d",
                "#40bfc1",
                "#1b262c",
                "#52de97",
                "#3e206d",
                "#12cad6",
              ],
              //borderColor : '#FFFF',
              borderWidth: "3px",
            },
          ],
        },
        options: {
          cutoutPercentage: 50,
          scales: {
            xAxes: false,
            yAxes: false,
          },
          legend: {
            display: true,
            position: "right",
            labels: {
              fontColor: "rgb(255, 99, 132)",
            },
          },
        },
      });

      let req = document.getElementById("req").getContext("2d");

      let bar = new Chart(req, {
        type: "bar",
        data: {
          labels: [
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednsday",
            "Thursday",
            "Friday",
            "Saturday",
          ],
          datasets: [
            {
              label: "Count",
              data: [10, 30, 1, 30, 50, 70, 90],
              backgroundColor: [
                "#fa163f",
                "#f0134d",
                "#40bfc1",
                "#1b262c",
                "#52de97",
                "#3e206d",
                "#12cad6",
              ],
              //borderColor : '#FFFF',
              borderWidth: "3px",
            },
          ],
        },
        options: {
          cutoutPercentage: 50,
          scales: {
            xAxes: [
              {
                gridLines: {
                  color: "rgba(0, 0, 0, 0)",
                },
              },
            ],
            yAxes: [
              {
                gridLines: {
                  display: true,
                },
              },
            ],
          },
        },
      });

      let tank = document.getElementById("tank").getContext("2d");

      let statOne = new Chart(tank, {
        type: "line",
        data: {
          labels: [
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednsday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednsday",
            "Thursday",
            "Friday",
            "Saturday",
          ],
          datasets: [
            {
              label: "Liters",
              data: [10, 30, 1, 30, 50, 70, 60, 10, 30, 1, 30, 50, 70, 90],

              //borderColor : '#FFFF',
              borderWidth: "3",
              borderColor: "red",
              fill: false,
              pointBackgroundColor: "red",
              pointBorderWidth: "5",
              //backgroundColor: 'red'
            },
          ],
        },
        options: {
          cutoutPercentage: 50,
          scales: {
            xAxes: [
              {
                gridLines: {
                  color: "rgba(0, 0, 0, 0)",
                },
              },
            ],
            yAxes: [
              {
                gridLines: {
                  display: true,
                },
              },
            ],
          },
        },
      });
    </script>
    <!--end of the charts-->
  </body>
</html>
